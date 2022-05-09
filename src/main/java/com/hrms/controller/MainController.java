package com.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ian
 */
@Controller
@RequestMapping(value = "/hrms")
public class MainController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/main1")
    public String main() {
        return "main";
    }


    
}
