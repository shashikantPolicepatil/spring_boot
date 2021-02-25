/**
 * 
 */
package com.example.demo.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Student;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentRepository;

/**
 * @author hp
 *
 */
@Component
@Order(value = 1)
public class DataRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Employee e1 = new Employee("Test");
		Employee e2 = new Employee("Test b");
		
		Student s1 = new Student("Abc",1200);
		Student s2 = new Student("Def",1200);
		
		employeeRepo.save(e1);
		employeeRepo.save(e2);
		
		Student save = studentRepository.save(s1);
		System.out.println(save);
		studentRepository.save(s2);
		
		Optional<Employee> emp = employeeRepo.findById(1);
		if(emp.isPresent()) {
				Employee rec = emp.get();
				System.out.println(rec);
		}
			else
				System.out.println("No Data found");
		
	}

}
