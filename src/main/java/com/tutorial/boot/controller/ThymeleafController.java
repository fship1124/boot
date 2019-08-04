package com.tutorial.boot.controller;

import com.tutorial.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ThymeleafController {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/th")
    public String templatePage(Model model){
        model.addAttribute("message", "boot template");
        return "th";
    }

    @RequestMapping(value = "/th2")
    public String templatePage2(Model model) {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("color", "red");
        pageMap.put("name", "jam");
        pageMap.put("price", 3000);
        model.addAttribute("product", pageMap);
        return "th2";
    }

    @RequestMapping("/th3")
    public String templatePage3(Model model) {
        model.addAttribute("products", service.getProductList());
        return "th3";
    }
}
