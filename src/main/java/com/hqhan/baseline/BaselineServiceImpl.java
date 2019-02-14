package com.hqhan.baseline;

import com.hqhan.AddBugsParamsVo;
import com.hqhan.RemoveBugsParamsVo;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Set;

/**
 * 〈description〉<br>
 * 〈baseline service impl〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-14 21:16
 */
public class BaselineServiceImpl implements BaselineServiceI{

    @Override
    public Map<String, Object> addBugsToBaseline(Set<AddBugsParamsVo> bugsInfo) {

        return null;
    }

    @Override
    public Map<String, Object> removeBugsFromBaseline(Set<RemoveBugsParamsVo> removeInfo) {
        return null;
    }
}
