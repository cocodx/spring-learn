package com.springframework.learn.componentscan;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 22/1/2022 δΈε11:53
 */
@Data
@Controller
public class PersonTestController {

    @Autowired
    private PersonService personService;

}
