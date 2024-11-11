package com.june.yorushika_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class YorushikaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YorushikaJavaApplication.class, args);

		System.out.println(LocalDateTime.now());
	}
}