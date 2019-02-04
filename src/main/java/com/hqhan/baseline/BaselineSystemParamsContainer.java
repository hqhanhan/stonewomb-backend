package com.hqhan.baseline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * baseline properties
 *
 * @author hqhan8080@Gmail.com
 * @date 2019/02/04 05:38
 * @version V1.0
 */
@Component
public class BaselineSystemParamsContainer {

    private boolean enableBaseline = false;
    private boolean enableBaselineBranch = false;
    private Set<String> enableBaselineExcludeModules = new HashSet<>();
    private Set<String> disableBaselineExcludeModules = new HashSet<>();
    private boolean printBaselineData = false;
    private long baselineMaxRecodes = -1;

    @Autowired
    private StringRedisTemplate redisTemplate;


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
     * @params []
     * @return void
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 08:35
     * @version V1.0
     */
    public void freshContainer() {
        //TODO according to the format of the cache to query system property
        this.enableBaseline = false;
        this.enableBaselineBranch = false;
        this.enableBaselineExcludeModules = new HashSet<>();
        this.disableBaselineExcludeModules = new HashSet<>();
        this.baselineMaxRecodes = -1;
        printBaselineData = false;
    }

}
