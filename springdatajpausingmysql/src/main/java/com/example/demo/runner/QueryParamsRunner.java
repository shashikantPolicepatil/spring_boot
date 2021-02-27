/**
 * 
 */
package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

/**
 * @author hp
 *
 */
@Component
public class QueryParamsRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		List<Employee> allEmpBySal = empRepo.getAllEmpBySal(100);
		
	}

}
