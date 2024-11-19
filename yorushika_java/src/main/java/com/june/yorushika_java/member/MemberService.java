package com.june.yorushika_java.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveMember(Map<String, String> formData) throws Exception {
        Member targetMember = new Member();

        targetMember.setUsername(formData.get("username"));
        if (formData.get("password").length() > 7) {
            targetMember.setPassword(passwordEncoder.encode(formData.get("password")));
        }
        targetMember.setDisplayName(formData.get("displayName"));
        if (!formData.get("age").isEmpty()) {
            targetMember.setAge(Integer.parseInt(formData.get("age")));
        }

        if (targetMember.isValid()) {
            memberRepository.save(targetMember);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "회원가입 정보입력 잘못되었음"
            );
        }
    }

}
