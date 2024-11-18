package com.june.yorushika_java.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    String signup() {
        return "signup.html";
    }

    @PostMapping("/registerMember")
    String registerMember(@RequestParam Map<String, String> formData) throws Exception {
        System.out.println(formData);
        memberService.saveMember(formData);
        return "redirect:/list";
    }

    @GetMapping("/login")
    String login() {
        return "login.html";
    }

}
