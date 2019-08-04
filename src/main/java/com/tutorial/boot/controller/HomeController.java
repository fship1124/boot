package com.tutorial.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String hello() {
        return "hi boot";
    }
    @RequestMapping("/a")
    public String a1() {
        return "hi a";
    }
}
