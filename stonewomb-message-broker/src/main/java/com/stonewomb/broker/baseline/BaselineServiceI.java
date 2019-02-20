package com.stonewomb.broker.baseline;

import com.stonewomb.broker.baseline.vo.AddBugsParamsVo;
import com.stonewomb.broker.baseline.vo.RemoveBugsParamsVo;

import java.util.Map;
import java.util.Set;

/**
 * 〈description〉<br>
 * 〈add、remove baseline〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-14 21:09
 */
public interface BaselineServiceI extends BaselineResult {



    /**
     * description: <br>
     * 〈添加缺陷至基线库〉
     * @param addInfos bugId以及每一个缺陷对应的添加人及添加原因
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *     resultStatus:
     *              paramsError
     *              partySuccess
     *              success
     *              systemError
     *     resultMsg：
     *              paramsJsonString
     *              部分bugId合法
     *              成功
     *              系统异常，告知开发人员
     *     resultData：
     *              {"illegalBugIds":[],"inBaselineBugIds":[]}
     *
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/14 21:15
     */
    Map<String,Object> addBugsToBaseline(Set<AddBugsParamsVo> addInfos);




    /**
     * description: <br>
     * 〈删除基线库中的数据〉
     * @param removeInfo bugId以及每一个缺陷对应的删除人及删除原因
     *     resultStatus:
     *              paramsError
     *              partySuccess
     *              success
     *              systemError
     *     resultMsg：
     *              paramsJsonString
     *              部分bugId在基线库中
     *              成功
     *              系统异常，告知开发人员
     *     resultData：
     *              {"illegalBugIds":[]}
     *
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @version V1.0
     * @author hqhan8080@Gmail.com
     * @date 2019/02/14 22:03
     */
    Map<String,Object> removeBugsFromBaseline(Set<RemoveBugsParamsVo> removeInfo);



}
