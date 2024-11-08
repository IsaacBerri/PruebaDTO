package com.nodo.demo;

import com.nodo.demo.Models.Personas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringProjectApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);
	}
}
