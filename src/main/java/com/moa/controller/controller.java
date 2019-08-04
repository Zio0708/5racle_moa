package com.moa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("/home")
    public String hello(){
        System.out.println("hello");
        return "home";
    }
}
