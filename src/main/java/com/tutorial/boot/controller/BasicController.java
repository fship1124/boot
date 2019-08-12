package com.tutorial.boot.controller;

import com.tutorial.boot.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BasicController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/todo")
    @CrossOrigin
    public Todo basic() {

        return new Todo(counter.incrementAndGet(), "라면사오기");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    @CrossOrigin
    public ResponseEntity<?> upload(@RequestParam("extraField") String extraField, @RequestParam("file") MultipartFile[] files) {
        System.out.println(extraField);
        System.out.println(files.length);

        //return new Todo(counter.incrementAndGet(), "라면사오기");
        return new ResponseEntity("Successfully uploaded - " + extraField, HttpStatus.OK);
    }

    @RequestMapping(value = "/todop", method = RequestMethod.POST)
    public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @RequestMapping(value = "/todor", method = RequestMethod.POST)
    public ResponseEntity<Todo> postBasicR(@RequestParam(value = "todoTitle") String todoTitle) {
        return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todos/{todoId}")
    public Todo getPath(@PathVariable int todoId) {
        Todo t1 = new Todo(1L, "문서쓰기");
        Todo t2 = new Todo(1L, "문서쓰기2");
        Todo t3 = new Todo(1L, "문서쓰기3");

        Map<Integer, Todo> todoMap = new HashMap<>();
        todoMap.put(1, t1);
        todoMap.put(2, t2);
        todoMap.put(3, t3);

        return todoMap.get(todoId);
    }

}
