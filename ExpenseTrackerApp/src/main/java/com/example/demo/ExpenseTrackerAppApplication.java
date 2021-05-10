package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 
 * @author hp
 *
 */
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
