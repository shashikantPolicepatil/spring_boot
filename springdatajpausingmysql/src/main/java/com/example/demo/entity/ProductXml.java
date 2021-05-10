package com.example.demo.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductXml {

	int id;
	String name;
	
	public ProductXml() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
