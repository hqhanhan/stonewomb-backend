package com.hqhan.baseline;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewbotBaselineRedisManagerITest {


    private static final String CHECKER = "checker";

    private static final String MODULE = "module";

    private static final String BRANCH = "branch";


    private ReviewbotBaselineManagerI baselineManager;


    @Test
    public void add() {
        Set<JSONObject> defects = new HashSet<>();
        baselineManager.add(defects);
    }


    @Test
    public void get() {


    }

    @Test
    public void delete() {

    }


    @Test
    public void exist() {

    }



}