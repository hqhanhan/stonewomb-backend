package com.hqhan.baseline;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * description : baseline service
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-04 14:10
 */
public interface ReviewbotBaselineServiceI {

    /**
     * add defects to baseline
     *
     * @return java.util.Set<java.lang.String> which defects already in baseline
     * @params [defects]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 14:30
     * @version V1.0
     */
    Set<JSONObject> addDefectsToBaseline(Set<JSONObject> defects);


    /**
     * remove defects to baseline
     *
     * @return java.util.Set<com.alibaba.fastjson.JSONObject> which defects do not exists in baseline
     * @params [defects]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 14:41
     * @version V1.0
     */
    Set<JSONObject> removeDefectsFromBaseline(Set<JSONObject> defects);

    /**
     * refresh system property from cache
     *
     * @return void
     * @params []
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 13:22
     * @version V1.0
     */
    void refreshContainer();

}
