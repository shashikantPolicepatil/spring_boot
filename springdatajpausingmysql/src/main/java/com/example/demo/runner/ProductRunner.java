/**
 * 
 */
package com.example.demo.runner;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

/**
 * @author hp
 *
 */
@Component
@Order(value = 111)
public class ProductRunner implements CommandLineRunner {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		List<Product> prodList = Arrays.asList(new Product("PEN", 25.0, "SNTY",new Date(),new Date(),new Date()	),new Product("BTL", 125.0, "SNTY",new Date(),new Date(),new Date()),new Product("KYBRD", 2500.0, "NIT",new Date(),new Date(),new Date()),
				new Product(),new Product("MOUSE", 180.0, "NIddT",new Date(),new Date(),new Date()),new Product("PEN", 25.0, "SNTY",new Date(),new Date(),new Date()),new Product("BTL", 125.0, "SNTY",new Date(),new Date(),new Date()),new Product("KYBRD", 2500.0, "NIT",new Date(),new Date(),new Date()),
				new Product(),new Product("MOUSE", 180.0, "NITkj",new Date(),new Date(),new Date()),
				new Product("PEN", 25.0, "ddSNTY",new Date(),new Date(),new Date()),new Product("BddTL", 125.0, "SNTY",new Date(),new Date(),new Date()),new Product("KYBRD", 2500.0, "NIdddT",new Date(),new Date(),new Date()),
				new Product(),new Product("MddOUSE", 180.0, "NIT",new Date(),new Date(),new Date()));
		
		final String data = "This is just test king of thing..This is just test king of thing..This is just test king of thing..This is just test king of thing..";
		FileInputStream img = new FileInputStream("E:/Spring_Boot/spring data jpa/SpringBoot9AM_22012021.png");		
		byte[] insert = new byte[img.available()];
		img.read(insert);
		
		char[] insert2 = data.toCharArray();
		
		Product p = new Product(insert,insert2);
		
		productRepository.saveAll(prodList);
		
		productRepository.save(p);
	}

}
