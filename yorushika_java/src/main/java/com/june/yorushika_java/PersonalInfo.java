package com.june.yorushika_java;


import lombok.Getter;

@Getter
public class PersonalInfo {
    private String name = "June";
    private Integer age = 26;

    public void addAge1() {
        this.age++;
    }

    public void setAge(Integer age) {
        if (age >= 0 && age < 100) {
            this.age = age;
        }
    }
}
