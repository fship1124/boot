package com.tutorial.boot.controller;

import com.tutorial.boot.model.Todo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BasicController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/todo")
    public Todo basic() {
        return new Todo(counter.incrementAndGet(), "라면사오기");
    }


}
