/**
 * 
 */
package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Expense;
import com.example.demo.exception.CustomException;
import com.example.demo.service.ExpenseService;

/**
 * @author hp
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/expense")
public class ExpenseResource {

	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping("/addExpense")
	public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
		try {
			expense = expenseService.doExpenseOpr(expense, ExpenseService.ADD).get(0);
			return new ResponseEntity<Expense>(expense,HttpStatus.CREATED);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@PostMapping("/editExpense")
	public ResponseEntity<Expense> editExpense(@RequestBody Expense expense) {
		try {
			expense = expenseService.doExpenseOpr(expense, ExpenseService.EDIT).get(0);
			return new ResponseEntity<Expense>(expense,HttpStatus.CREATED);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeExpense(@PathVariable Integer id) {
		try {
			 expenseService.doExpenseOpr(new Expense(id,null,null,null,null), ExpenseService.DELETE);
			return new ResponseEntity<String>("Removed successfully",HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@GetMapping("/loadAllExpense")
	public ResponseEntity<List<Expense>> loadAllExpenses() {
		try {
			List<Expense> expenseList = expenseService.doExpenseOpr(null, ExpenseService.GET_ALL);
			return new ResponseEntity<List<Expense>>(expenseList,HttpStatus.OK);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
}
