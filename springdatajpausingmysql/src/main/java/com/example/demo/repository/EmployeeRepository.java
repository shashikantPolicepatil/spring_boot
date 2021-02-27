/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

	  /**using parameters **/
	  //Position params
	  @Query("from Employee e where e.eSal>?1")
	  public List<Employee> getAllEmpBySal(Integer esal);
	  
	  @Query("from Employee e where e.id=?1")
	  public Employee getOneEmpById(Integer id);
	  
	  @Query("from Employee e where e.id=?1 or e.fname=?2")
	  public Object getEmpByIdOrName(Integer id,String name);
	  
	  //Named params
	  @Query("from Employee e where e.eSal>:esal")
	  public List<Employee> getAllEmpBySal1(Integer esal);
	  
	  @Query("from Employee e where e.id=:id")
	  public Employee getOneEmpById1(Integer id);
	  
	  @Query("from Employee e where e.id=:id or e.fname=:name")
	  public Object getEmpByIdOrName1(Integer id,String name); 
	  
	  //or
	  //	  public Object getEmpByIdOrName1(String name,Integer id);
}
