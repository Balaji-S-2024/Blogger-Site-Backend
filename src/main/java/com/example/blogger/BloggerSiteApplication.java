package com.example.blogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.example.blogger.repository")
@SpringBootApplication
public class BloggerSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggerSiteApplication.class, args);
		
	}

}
