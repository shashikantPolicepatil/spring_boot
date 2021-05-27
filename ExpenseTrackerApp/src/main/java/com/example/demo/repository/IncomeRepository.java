package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer>{

	/*
	 * @Query("select sum(in.credit) from Income in") public BigDecimal
	 * getTotalCreditAmount();
	 */
	
	@Query("select inn from Income inn where inn.incomeDate=:month")
	public List<Income> findByMonth(@Param("month") Date month);
}
