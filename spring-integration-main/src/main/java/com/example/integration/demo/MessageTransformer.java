package com.example.integration.demo;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class MessageTransformer {

    @Transformer(inputChannel = "routerOutputChannel", 
                    outputChannel = "transformerOutputChannel")
    public String transformOutput(String message) {
        return message.toUpperCase();
    }

   
}