package com.june.yorushika_java.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/signup")
    String signup(Authentication auth) {
        if (auth != null) {
            return "redirect:/list";
        }
        return "signup.html";
    }

    @PostMapping("/registerMember")
    String registerMember(@RequestParam Map<String, String> formData) throws Exception {
        System.out.println(formData);
        memberService.saveMember(formData);
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login() {
        var result = memberRepository.findByUsername("testtest");
        System.out.println(result);
        return "login.html";
    }

    @GetMapping("/mypage")
    public String myPage(Authentication auth) {
        if (auth == null) {
            return "login.html";
        }

        System.out.println(auth);
        System.out.println(auth.getName());

        System.out.println(auth.getAuthorities().contains(new SimpleGrantedAuthority("default")));

        CustomUser result = (CustomUser) auth.getPrincipal();
        System.out.println(result.getDisplayName());

        return "mypage.html";
    }
}
