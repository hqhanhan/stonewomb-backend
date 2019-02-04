package com.hqhan.baseline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * baseline operate for redis
 *
 * @author hqhan8080@Gmail.com
 * @date 2019/02/04 06:42
 * @version V1.0
 */
@Component
public class ReviewbotBaselineRedisManager implements ReviewbotBaselineManagerI {

    private static final String PREFIX_KEY = "baseline";

    private static final String SPACE = ":";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private BaselineSystemProperty systemProperty;


    Map<String, String> filterMap = new HashMap<>();


    @Override
    public void add(Set<JSONObject> defects) {
        Map<String, String> insertMap = new HashMap<>();
        for (JSONObject defect : defects) {
            String key = buildKey(defect);
            insertMap.put(key, defect.toJSONString());
            if (insertMap.size() % 1000 == 0) {
                Boolean aBoolean = redisTemplate.opsForValue().multiSetIfAbsent(insertMap);
                if (aBoolean) {
                    insertMap.clear();
                }
            }
        }
        redisTemplate.opsForValue().multiSetIfAbsent(insertMap);
    }


    @Override
    public Set<JSONObject> get(Set<String> keys) {
        List<String> arrayStr = redisTemplate.opsForValue().multiGet(keys);
        JSONArray objects = JSON.parseArray(arrayStr.toString());
        return new HashSet(objects);
    }

    @Override
    public boolean exist(JSONObject defect) {
        String key = buildKey(defect);
        return redisTemplate.hasKey(key);
    }

    @Override
    public Long delete(Set<String> keys) {
        return redisTemplate.delete(keys);
    }


    @Override
    public String buildKey(JSONObject defect) {
        if (CollectionUtils.isEmpty(defect)) {
            return "";
        }
        String checker = defect.getString("checker");
        String module = defect.getString("module");
        String branch = defect.getString("branch");
        String bugHashStr = generateHashStr(defect);
        StringBuilder key = new StringBuilder(PREFIX_KEY);
        if (StringUtils.isEmpty(checker) || StringUtils.isEmpty(module) || StringUtils.isEmpty(branch) || StringUtils.isEmpty(bugHashStr)) {
            throw new IllegalArgumentException("checker、module、branch、bugHashStr can not be set to blank ");
        }
        key.append(SPACE).append(checker).append(SPACE).append(module).append(SPACE).append(branch).append(SPACE).append(bugHashStr);
        return key.toString();
    }

    @Override
    public Set<String> getBaselineKeys(String checker, String module, String branch) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(checker) && StringUtils.isEmpty(module) && StringUtils.isEmpty(branch)) {
            sb.append(PREFIX_KEY).append("*");
        }
        if (StringUtils.isEmpty(checker) && StringUtils.isEmpty(module) && !StringUtils.isEmpty(branch)) {
            sb.append(PREFIX_KEY).append("*");
        }
        if (StringUtils.isEmpty(checker) && !StringUtils.isEmpty(module) && StringUtils.isEmpty(branch)) {
            sb.append("*").append(module).append("*");
        }
        if (StringUtils.isEmpty(checker) && !StringUtils.isEmpty(module) && !StringUtils.isEmpty(branch)) {
            sb.append("*").append(module).append(SPACE).append(branch).append("*");
        }
        if (!StringUtils.isEmpty(checker) && StringUtils.isEmpty(module) && StringUtils.isEmpty(branch)) {
            sb.append(PREFIX_KEY).append(SPACE).append(checker).append("*");
        }
        if (!StringUtils.isEmpty(checker) && StringUtils.isEmpty(module) && !StringUtils.isEmpty(branch)) {
            sb.append(PREFIX_KEY).append(SPACE).append(checker).append("*");
        }
        if (!StringUtils.isEmpty(checker) && !StringUtils.isEmpty(module) && StringUtils.isEmpty(branch)) {
            sb.append(PREFIX_KEY).append(SPACE).append(checker).append(SPACE).append(module).append("*");
        }
        if (!StringUtils.isEmpty(checker) && !StringUtils.isEmpty(module) && !StringUtils.isEmpty(branch)) {
            sb.append(PREFIX_KEY).append(SPACE).append(checker).append(SPACE).append(module).append(SPACE).append(branch).append("*");
        }
        Set<String> keys = redisTemplate.keys(sb.toString());
        return CollectionUtils.isEmpty(keys) ? new HashSet<>() : keys;
    }

    /**
     * description : create bug filter properties hash string
     *
     * @return java.lang.String
     * @params [bug]
     * @author hqhan8080@Gmail.com
     * @date 2019/02/04 06:44
     * @version V1.0
     */
    private String generateHashStr(JSONObject defect) {
        if (CollectionUtils.isEmpty(defect)) {
            throw new IllegalArgumentException("defect can not be set to null or blank ");
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry map : filterMap.entrySet()) {
            String valueKey = (String) map.getValue();
            String value = defect.getString(valueKey);
            if (value != null) {
                sb.append(value.trim().hashCode()).append("&");
            }
        }
        String hashStr = sb.toString();
        return StringUtils.isEmpty(hashStr) ? "" : hashStr.substring(0, hashStr.length() - 1);
    }


}
