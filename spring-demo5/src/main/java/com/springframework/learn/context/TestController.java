package com.springframework.learn.context;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 21/1/2022 上午4:24
 */
@Controller
@Data
public class TestController {

    @Autowired
    private TestService testService;
}
