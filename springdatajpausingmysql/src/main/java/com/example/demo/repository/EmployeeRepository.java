/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Employee;

/**
 * @author hp
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
