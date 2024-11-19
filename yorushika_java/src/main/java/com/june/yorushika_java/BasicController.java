package com.june.yorushika_java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    String hello() {
        return "Nice to meet you";
    }

    @GetMapping("/about")
    @ResponseBody
    String about() {
        return "I am Java SuperRookie June";
    }

//    @GetMapping("/mypage")
//    String mypage() {
//        return "index.html";
//    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/error")
    String error() {
        return "error.html";
    }

}