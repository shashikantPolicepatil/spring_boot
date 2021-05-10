/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Expense;

/**
 * @author hp
 *
 */
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
