package com.hqhan.baseline;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;


/**
 * 〈description〉<br>
 * 〈baseline data cache operate〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-04 05:37
 */
public interface ReviewbotBaselineManagerI {

    /**
     * description: <br>
     * 〈 put defects into cache〉
     *
     * @param defects
     * @return void
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 07:19
     */
    void add(Set<JSONObject> defects);


    /**
     * description: <br>
     * 〈get baseline data by keys〉
     *
     * @param keys
     * @return java.util.Set<com.alibaba.fastjson.JSONObject>
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 07:11
     */
    Set<JSONObject> get(Set<String> keys);


    /**
     * description: <br>
     * 〈 whether defect exists in the baseline〉
     *
     * @param defect
     * @return boolean
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:47
     */
    boolean exist(JSONObject defect);


    /**
     * description: <br>
     * 〈delete defect from base by keys〉
     *
     * @param keys
     * @return java.lang.Long
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:38
     */
    Long delete(Set<String> keys);


    /**
     * description: <br>
     * 〈build baseline key for defect〉
     *
     * @param defect
     * @return java.lang.String
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:52
     */
    String buildKey(JSONObject defect);


    /**
     * description: <br>
     * 〈get all baseline keys〉
     *
     * @return java.util.Set<java.lang.String>
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/08 23:16
     */
    Set<String> getBaselineKeys();


    /**
     * description: <br>
     * 〈get baseline data keys〉
     *
     * @param checker
     * @param module
     * @param branch
     * @return java.util.Set<java.lang.String>
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:50
     */
    Set<String> getBaselineKeys(String checker, String module, String branch);

}
