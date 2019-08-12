package com.tutorial.boot.controller;

import com.tutorial.boot.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> upload(@RequestParam("extraField") String extraField, @RequestParam("file") MultipartFile[] uploadfiles) {
        System.out.println(extraField);
        System.out.println(uploadfiles.length);

        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

        System.out.println(uploadedFileName.toString());

        return new ResponseEntity("Successfully uploaded - " + extraField, HttpStatus.OK);
    }



        @RequestMapping(value = "/curlUpload", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    @CrossOrigin
    public ResponseEntity<?> curlUpload(@RequestParam("file") MultipartFile[] files) {
        System.out.println(files.length);

        return new ResponseEntity("Successfully uploaded - " + "aaa", HttpStatus.OK);
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
