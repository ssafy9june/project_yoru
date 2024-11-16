package com.june.yorushika_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class YorushikaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YorushikaJavaApplication.class, args);
		var object = new PersonalInfo();
		System.out.println(object.getAge());
		System.out.println(object.getName());
		object.addAge1();
		System.out.println(object.getAge());
		object.setAge(30);
		System.out.println(object.getAge());
		object.setAge(120);
		System.out.println(object.getAge());
		object.setAge(-50);
		System.out.println(object.getAge());

	}
}