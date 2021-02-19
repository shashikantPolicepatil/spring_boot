package com.example.integration.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.example.integration.demo.IGateway;
import com.example.integration.demo.model.CachingServiceImpl;

@Component
public class InboundEnpoint {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private IGateway gateway;
	
	@Autowired
	CachingServiceImpl cachingServiceImpl;
	public Message<?> get(Message<?> msg) {
		log.info("GET method");
		String payload=cachingServiceImpl.getDataFromMap();
		return MessageBuilder.withPayload(payload).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();
	}
	
	public void post(Message<MessageObj> msg){
		log.info("POST method");
		gateway.processMessage(MessageBuilder.withPayload(msg.getPayload().getName()).build());
	}
	
}
