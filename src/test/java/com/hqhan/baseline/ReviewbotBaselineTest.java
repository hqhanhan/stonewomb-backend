package com.hqhan.baseline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewbotBaselineTest {


    private static final String CHECKER = "checker";

    private static final String MODULE = "module";

    private static final String BRANCH = "branch";

    @Autowired
    private ReviewbotBaselineServiceI baselineService;

    @Test
    public void add() {

    }


    @Test
    public void testProperty() {

        baselineService.refreshContainer();

    }

    @Test
    public void delete() {

    }


    @Test
    public void exist() {

    }


}