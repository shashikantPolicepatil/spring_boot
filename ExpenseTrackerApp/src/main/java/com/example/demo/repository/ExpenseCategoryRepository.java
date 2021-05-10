/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ExpenseCategory;

/**
 * @author hp
 *
 */
public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Integer>{

}
