package com.example.integration.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan
@ComponentScan
@ImportResource({"classpath:http-inbound-adapter.xml", "classpath:http-inbound-gateway.xml"})
public class DemoApplication {

	@Bean
	public MessageChannel defaultRequestChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel splitterOutputChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel filterOutputChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel leftOutOutputChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel routerOutputChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel transformerOutputChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel aggregatorOutputChannel() {
		return new DirectChannel();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*
		 * ApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(DemoApplication.class); IGateway
		 * orderGateway = ctx.getBean(IGateway.class);
		 * orderGateway.processMessage(MessageBuilder.withPayload("HI My name is Piyush"
		 * ).build());
		 */}

}
