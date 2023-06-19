package com.boo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boo.mapper")
//@ComponentScan("com.boo.controller")
public class BooApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooApplication.class, args);
	}

}
