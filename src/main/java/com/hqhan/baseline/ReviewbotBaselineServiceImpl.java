package com.hqhan.baseline;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * remove,add baseline
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-04 14:10
 */
@Service
public class ReviewbotBaselineServiceImpl implements ReviewbotBaselineServiceI {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReviewbotBaselineManagerI baselineManager;

    @Autowired
    private BaselineSystemParamsContainer container;

    @Override
    public Set<JSONObject> addDefectsToBaseline(Set<JSONObject> defects) {
        if (CollectionUtils.isEmpty(defects)) {
            return new HashSet<>();
        }
        Set<JSONObject> outOfBaseline = defects.stream().filter(defect -> !baselineManager.exist(defect)).collect(Collectors.toSet());
        //TODO insert defects to mongo baseline
        baselineManager.add(outOfBaseline);
        defects.removeAll(outOfBaseline);
        printInvalidDefectIds(defects);
        return defects;
    }


    @Override
    public Set<JSONObject> removeDefectsFromBaseline(Set<JSONObject> defects) {
        Set<JSONObject> inBaseline = defects.stream().filter(defect -> baselineManager.exist(defect)).collect(Collectors.toSet());
        Set<String> keys = new HashSet<>();
        inBaseline.forEach(defect -> {
            String key = baselineManager.buildKey(defect);
            if (!StringUtils.isEmpty(key)) {
                keys.add(key);
            }
        });
        //TODO remove defects from mongo baseline and insert defects into mongo
        baselineManager.delete(keys);
        defects.removeAll(inBaseline);
        printInvalidDefectIds(defects);
        return defects;
    }

    @Override
    public void refreshContainer() {
        container.refreshContainer();
    }


    @Component
    class BaselineSystemParamsContainer {

        private boolean enableBaseline = false;
        private boolean enableBaselineBranch = false;
        private Set<String> enableBaselineExcludeModules = new HashSet<>();
        private Set<String> disableBaselineExcludeModules = new HashSet<>();
        private boolean printBaselineData = false;
        private long baselineMaxRecodes = -1;

        public boolean isEnableBaseline() {
            return enableBaseline;
        }
        public boolean isEnableBaselineBranch() {
            return enableBaselineBranch;
        }
        public Set<String> getEnableBaselineExcludeModules() {
            return enableBaselineExcludeModules;
        }
        public Set<String> getDisableBaselineExcludeModules() {
            return disableBaselineExcludeModules;
        }
        public long getBaselineMaxRecodes() {
            return baselineMaxRecodes;
        }
        public boolean isPrintBaselineData() {
            return printBaselineData;
        }

        /**
         * description : fresh system property about baseline
         *
         * @return void
         * @params []
         * @author hqhan8080@Gmail.com
         * @date 2019/02/04 08:35
         * @version V1.0
         */
        void refreshContainer() {
            //TODO according to the format of the cache to query system property
            logger.info("todo refresh system property");
        }
    }

    private void printInvalidDefectIds(Set<JSONObject> defects) {
        if (!CollectionUtils.isEmpty(defects)) {
            JSONArray invalidIds = new JSONArray();
            defects.forEach(defect -> {
                String bugId = defect.getString("bugId");
                invalidIds.add(bugId);
            });
            logger.info("addDefectsToBaseline invalid defect bugIds：" + invalidIds.toJSONString());
        }
    }


}
