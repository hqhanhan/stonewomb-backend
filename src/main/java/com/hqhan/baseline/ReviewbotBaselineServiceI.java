package com.hqhan.baseline;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * 〈description〉<br>
 * 〈 baseline operate for redis〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019/02/04 06:42
 */
public interface ReviewbotBaselineServiceI {

    /**
     * description: <br>
     * 〈add defects to baseline〉
     *
     * @param defects
     * @return java.util.Set<com.alibaba.fastjson.JSONObject>
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 14:30
     */
    Set<JSONObject> addDefectsToBaseline(Set<JSONObject> defects);

    /**
     * description: <br>
     * 〈remove defects to baseline〉
     *
     * @param defects
     * @return java.util.Set<com.alibaba.fastjson.JSONObject>
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 14:41
     */
    Set<JSONObject> removeDefectsFromBaseline(Set<JSONObject> defects);


    /**
     * description: <br>
     * 〈refresh system property from cache〉
     *
     * @param
     * @return void
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 13:22
     */
    void refreshContainer();

}
