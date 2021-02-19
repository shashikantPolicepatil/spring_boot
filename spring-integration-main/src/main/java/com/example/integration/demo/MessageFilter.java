package com.example.integration.demo;

import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;

@MessageEndpoint
public class MessageFilter {

    
    @Filter(inputChannel="splitterOutputChannel", outputChannel="filterOutputChannel", discardChannel="leftOutOutputChannel")
    public boolean filterMessageNotNull(String message) {
        return message!=null;
    }
}