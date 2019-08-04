package com.tutorial.boot.controller;

import com.tutorial.boot.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BasicController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/todo")
    public Todo basic() {
        return new Todo(counter.incrementAndGet(), "라면사오기");
    }

    @RequestMapping(value = "/todop", method = RequestMethod.POST)
    public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @RequestMapping(value = "/todor", method = RequestMethod.POST)
    public ResponseEntity<Todo> postBasicR(@RequestParam(value = "todoTitle") String todoTitle) {
        return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }
}
