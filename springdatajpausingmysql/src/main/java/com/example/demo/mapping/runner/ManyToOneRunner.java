/**
 * 
 */
package com.example.demo.mapping.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.VendorRepository;

/**
 * @author hp
 *
 */
@Component
public class ManyToOneRunner implements CommandLineRunner {

	@Autowired
	private VendorRepository vendorRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Vendor v1 = new Vendor("ABC", "HYD");
		Vendor v2 = new Vendor("NIT", "DHL");
		
		//vendorRepo.saveAll(Arrays.asList(new Vendor("ABC","HYD"),new Vendor("NIT","DHL")));
		vendorRepo.save(v1);
		vendorRepo.save(v2);
		
		productRepo.saveAll(Arrays.asList(new Product("PEN", 20.0, "A", v1),
		new Product("PEN", 20.0, "A", v1),
		new Product("BOOK", 40.0, "B", null),
		new Product("BOOK", 40.0, "B", v1),
		new Product("BTL", 80.0, "A", null),
		new Product("BTL", 80.0, "A", v2),
		new Product("INK", 50.0, "A", v2)));
	}

}
