package com.hqhan.baseline;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * description:
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-04 05:37
 */
public interface ReviewbotBaselineManagerI {


    /**
     * description : put defects into cache
     *
     * @params [defects]
     * @return void
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 07:19
     * @version V1.0
     */
    void add(Set<JSONObject> defects);


    /**
     * description : get baseline data by keys
     *
     * @return java.util.Set<com.alibaba.fastjson.JSONObject>
     * @params [keys]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 07:11
     * @version V1.0
     */
    Set<JSONObject> get(Set<String> keys);


    /**
     * description : whether defect exists in the baseline
     *
     * @return boolean
     * @params [bug]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:47
     * @version V1.0
     */
    boolean exist(JSONObject defect);


    /**
     * description : delete defect from base by keys
     *
     * @return java.lang.Long
     * @params [keys]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:38
     * @version V1.0
     */
    Long delete(Set<String> keys);


    /**
     * description : build baseline key for defect
     *
     * @return java.lang.String
     * @params [defect]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:52
     * @version V1.0
     */
    String buildKey(JSONObject defect);


    /**
     * description : get baseline data keys
     *
     * @return java.util.Set<java.lang.String>
     * @params [checker, module, branch]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:50
     * @version V1.0
     */
    Set<String> getBaselineKeys(String checker, String module, String branch);
}
