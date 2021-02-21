/**
 * 
 */
package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

/**
 * @author hp
 *
 */
@Component
public class PagingRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		int offSet = 5;
		int pageNum=0;
		Pageable pageAble = PageRequest.of(pageNum, offSet);
		Page<Product> page = productRepo.findAll(pageAble);
		List<Product> content = page.getContent();
		
		content.forEach(System.out::println);
		
		//--meta data---
				System.out.println("First Page : " + page.isFirst());
				System.out.println("Last Page : " + page.isLast());
				System.out.println("Next Page? : " + page.hasNext());
				System.out.println("Previous Page? : " + page.hasPrevious());
				System.out.println("Empty Page? : " + page.isEmpty());
				System.out.println("Page Size? : " + page.getSize());
				System.out.println("Page Number? : " + page.getNumber());
				System.out.println("Total Pages? : " + page.getTotalPages());
				System.out.println("Total Rows? : " + page.getTotalElements());
	}

}
