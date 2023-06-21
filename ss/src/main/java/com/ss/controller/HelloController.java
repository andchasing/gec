package com.ss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/index")
    public String index(){
        return "this is index page!";
    }
}
