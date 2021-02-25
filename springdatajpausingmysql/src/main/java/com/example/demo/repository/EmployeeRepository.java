/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

/**
 * @author hp
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	  @Query(" from Employee e ") 
	  public List<Employee> getAllEmps();
	  
	  @Query("select e.fname from Employee e ") 
	  public List<String> getAllEmpNames();
	  
	  @Query("select e.id,e.fname from Employee e ") 
	  public List<Object[]> getAllEmpNamesIds();
	 
}
