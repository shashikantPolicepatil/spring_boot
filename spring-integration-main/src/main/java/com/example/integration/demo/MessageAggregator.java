package com.example.integration.demo;

import java.util.List;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;

@MessageEndpoint
public class MessageAggregator {

	@Aggregator(inputChannel="transformerOutputChannel",outputChannel = "aggregatorOutputChannel")
    public String route(List<String> message) {
		StringBuilder builder=new StringBuilder();
		for(String s:message) {
			builder.append(s).append(" ");
		}
		return builder.toString();
	}
	
}
