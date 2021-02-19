package com.example.integration.demo;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class LeftoutMessageListener {

@ServiceActivator(inputChannel = "cargoFilterDiscardChannel")
public void handleDiscardedMessage(String cargo) {
}

}