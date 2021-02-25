/**
 * 
 */
package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentColMappingReposiroty;

/**
 * @author hp
 *
 */
@Component
public class CustomQueryRunner implements CommandLineRunner {

	@Autowired
	private StudentColMappingReposiroty mappingRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(empRepo.getAllEmps());
		System.out.println(empRepo.getAllEmpNames());
		empRepo.getAllEmpNamesIds().forEach(System.out::println);
		System.out.println();
	}

}
