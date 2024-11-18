package com.june.yorushika_java.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import static org.thymeleaf.util.StringUtils.length;

@Entity
@ToString
@Getter
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String displayName;

    private Integer age;

    public boolean isValid() {
        return StringUtils.hasText(this.username) &&
               StringUtils.hasText(this.password) &&
               StringUtils.hasText(this.displayName) &&
               length(this.username) >= 8;
    }
}
