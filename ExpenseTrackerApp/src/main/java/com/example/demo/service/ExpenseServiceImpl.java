/**
 * 
 */
package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Expense;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.util.ExpenseUtility;

/**
 * @author hp
 *
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

	private ExpenseRepository expenseRepository;
	
	@Autowired
	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	@Override
	public List<Expense> doExpenseOpr(Expense expense, String actionName) {
		switch(actionName) {
		case ADD:
			expense.setMonth(ExpenseUtility.getMonthInString(expense.getExpenseDate()));
			return Arrays.asList(expenseRepository.save(expense));
		case EDIT:
			expense.setMonth(ExpenseUtility.getMonthInString(expense.getExpenseDate()));
			return Arrays.asList(expenseRepository.save(expense));
		case GET_ALL:
			return expenseRepository.findAll(Sort.by("expenseDate"));
		default:
			expenseRepository.findAll();
		}
		return null;
	}

	
}
