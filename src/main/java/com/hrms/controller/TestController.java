package com.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ian
 */
@Slf4j
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index() {
        log.debug("test : {} ", "測試。。。");
        return "test";
    }
}
