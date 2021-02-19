package com.example.integration.demo;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "gateway", 
defaultRequestChannel = "defaultRequestChannel")
public interface IGateway {

@org.springframework.integration.annotation.Gateway
void processMessage(Message<String> message);
}