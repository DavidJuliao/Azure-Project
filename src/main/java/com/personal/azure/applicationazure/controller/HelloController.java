package com.personal.azure.applicationazure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/testGroup")
    @ResponseBody
    @PreAuthorize("hasRole(ROLE_testGroup)")
    public String group1(){
        return "Hello Worlds testGroup User1!";
    }

    @GetMapping("/group2")
    @ResponseBody
    @PreAuthorize("hasRole(ROLE_testGroup1)")
    public String group2(){
        return "Hello Worlds testGroup User2!";
    }
}
