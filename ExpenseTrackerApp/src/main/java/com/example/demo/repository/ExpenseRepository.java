/**
 * 
 */
package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Expense;

/**
 * @author hp
 *
 */
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	/*
	 * @Query("select sum(e.amount) from Expense e") public BigDecimal
	 * getTotalDebitAmount();
	 */
	
	@Query("select ex from Expense ex where ex.month=?1")
	public List<Expense> findByMonth(String month);
}
