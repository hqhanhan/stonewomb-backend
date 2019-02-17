package com.huawei.reviewbot.baseline;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

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
        Set<JSONObject> defects = new HashSet<>();
        for (int i = 0; i < 500000; i++) {
            JSONObject defect = new JSONObject();
            defect.put(CHECKER, CHECKER);
            defect.put(MODULE, MODULE);
            defect.put(BRANCH, BRANCH);
            String value = String.valueOf(i);
            defect.put("bugId", value);
            defect.put("fileName", value);
            defect.put("defectType", value);
            defect.put("mainBugCode", value);
            defect.put("analyzerName", value);
            defects.add(defect);
            if (defects.size() % 10000 == 0) {
                baselineService.addDefectsToBaseline(defects);
                defects.clear();
                System.out.println(i);
            }
        }
        baselineService.addDefectsToBaseline(defects);

    }

    @Test
    public void get() {


    }


    @Test
    public void remove() {

        Set<JSONObject> defects = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            JSONObject defect = new JSONObject();
            defect.put(CHECKER, CHECKER);
            defect.put(MODULE, MODULE);
            defect.put(BRANCH, BRANCH);
            String value = String.valueOf(i);
            defect.put("bugId", value);
            defect.put("fileName", value);
            defect.put("defectType", value);
            defect.put("mainBugCode", value);
            defect.put("analyzerName", value);
            defects.add(defect);
            if (defects.size() % 10000 == 0) {
                baselineService.removeDefectsFromBaseline(defects);
                defects.clear();
                System.out.println(i);
            }
        }
        baselineService.removeDefectsFromBaseline(defects);
    }


    @Test
    public void exist() {

    }


}