/**
 * 
 */
package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

/**
 * @author hp
 *
 */
@Component
public class PagingAndSortingRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Iterable<Product> findAll = productRepo.findAll();
		findAll.forEach(System.out::println);
		
		Sort pCode = Sort.by("pcode"); //default asc
		productRepo.findAll(pCode).forEach(System.out::println);
		
		Sort pCodePcost =  Sort.by("pcode","pcost");
		productRepo.findAll(pCodePcost).forEach(System.out::println);; //default asc
		
		Sort pCodeDesc =  Sort.by(Direction.DESC,"pcode");
		productRepo.findAll(pCodeDesc).forEach(System.out::println);
	}

}
