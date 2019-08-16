package com.tutorial.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vue")
public class VueController {

    @RequestMapping(value = "/start")
    public String start(Model model) {
        model.addAttribute("message", "hello boot");

        return "vue/start";
    }
    @RequestMapping(value = "/instance")
    public String instance(Model model) {
        model.addAttribute("message", "about instance");

        return "vue/instance";
    }
    @RequestMapping(value = "/template")
    public String template(Model model) {
        model.addAttribute("message", "about instance");

        return "vue/template";
    }
    @RequestMapping(value = "/computed")
    public String computed(Model model) {
        model.addAttribute("message", "about instance");

        return "vue/computed";
    }
    @RequestMapping(value = "/watch")
    public String watch(Model model) {
        model.addAttribute("message", "about instance");

        return "vue/watch";
    }
}
