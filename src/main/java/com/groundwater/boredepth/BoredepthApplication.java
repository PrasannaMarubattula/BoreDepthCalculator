package com.groundwater.boredepth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class BoredepthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoredepthApplication.class, args);
	}

}
