package com.Blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		
		info=@Info(
				
				title = "Blog API",
				version= "v1.0",
				description= "API to handle the request for frontend."
				
				),
		
		servers = @Server(
				
				url = "http://localhost:8484/Blogger",
				description= "This API is deployed in the following url"
				
				)
		
		)
public class BloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggerApplication.class, args);
	}

}
