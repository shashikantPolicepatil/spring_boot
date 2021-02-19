package com.example.integration.demo;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;

@MessageEndpoint
public class MessageSplitter {

    @Splitter(inputChannel = "defaultRequestChannel", 
                outputChannel = "splitterOutputChannel")
    public String[] splitMessage(Message<String> message) {
        return message.getPayload().split("\\s");
    }
}