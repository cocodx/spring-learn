package com.springframework.learn.context;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 21/1/2022 δΈε4:24
 */
@Controller
@Data
public class TestController {

    @Autowired
    private TestService testService;
}
