package com.example.demo;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductXml;

public class CovertObjToXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		covertObjToXml();
		String str  = "S";
		str=str.replace("\"", "");
		System.out.println(str);
	}
	
	public static void covertObjToXml() {
		try {
		    // create an instance of `JAXBContext`
		    JAXBContext context = JAXBContext.newInstance(ProductXml.class);

		    // create an instance of `Marshaller`
		    Marshaller marshaller = context.createMarshaller();

		    // enable pretty-print XML output
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		    // create XML file
		    File file = new File("E://classes/product.xml");

		    // create `Book` object
		   ProductXml pd = new ProductXml();

		    // convert book object to XML file
		    marshaller.marshal(pd, file);

		} catch (JAXBException ex) {
		    ex.printStackTrace();
		}
	}

}
