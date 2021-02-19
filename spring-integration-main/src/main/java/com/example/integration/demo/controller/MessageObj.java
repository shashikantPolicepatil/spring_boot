package com.example.integration.demo.controller;

public class MessageObj {
	private String name;
	
	public MessageObj(){
	}
	
	public MessageObj(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		String info = String.format("Customer with name = %s", name);
		return info;
	}
}
