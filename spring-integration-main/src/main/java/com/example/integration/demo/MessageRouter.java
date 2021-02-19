package com.example.integration.demo;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

@MessageEndpoint
public class MessageRouter {

    @Router(inputChannel="filterOutputChannel")
    public String route(String message) {
        return "routerOutputChannel";
            }

}