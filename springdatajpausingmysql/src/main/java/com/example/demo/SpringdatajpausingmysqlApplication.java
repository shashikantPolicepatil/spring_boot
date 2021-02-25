package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class SpringdatajpausingmysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpausingmysqlApplication.class, args);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL, false);
		Product p = new Product("dkj&nbsp", null, "jjhjhjh", null, null, null);
		
		try {
			String n = objectMapper.writeValueAsString(p);
			String htmlUnescape = HtmlUtils.htmlUnescape(n);
			String escape = HtmlUtils.htmlEscape(n);
			System.out.println(n+"/"+htmlUnescape+"/"+escape);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
