package com.springframework.learn.readjson;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 10/3/2022 下午10:00
 */
public class TestController {

    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    public void sing(){
        testService.sing();
    }

    public TestService getTestService() {
        return testService;
    }
}
