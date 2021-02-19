package com.example.integration.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.example.integration.demo.model.CachingServiceImpl;

@MessageEndpoint
public class MessageServiceActivator {

	@Autowired
	CachingServiceImpl cachingServiceImpl;
	@ServiceActivator(inputChannel = "aggregatorOutputChannel")
	public void getMessage(String message) {
		cachingServiceImpl.updateDataInMap(message);
		System.out.println(message);
	}

}