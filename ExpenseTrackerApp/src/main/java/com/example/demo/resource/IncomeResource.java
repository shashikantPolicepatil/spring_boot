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

import com.example.demo.entity.Income;
import com.example.demo.exception.CustomException;
import com.example.demo.service.IncomeService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/income")
public class IncomeResource {

	@Autowired
	private IncomeService incomeService;
	
	
	@PostMapping("/addIncome")
	public ResponseEntity<Income> addIncome(@RequestBody Income Income) {
		try {
			Income = incomeService.doIncomeOpr(Income, IncomeService.ADD).get(0);
			return new ResponseEntity<Income>(Income,HttpStatus.CREATED);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@PostMapping("/editIncome")
	public ResponseEntity<Income> editIncome(@RequestBody Income Income) {
		try {
			Income = incomeService.doIncomeOpr(Income, IncomeService.EDIT).get(0);
			return new ResponseEntity<Income>(Income,HttpStatus.CREATED);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeIncome(@PathVariable Integer id) {
		try {
			 incomeService.doIncomeOpr(new Income(id,null,null,null), IncomeService.DELETE);
			return new ResponseEntity<String>("Removed successfully",HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@GetMapping("/loadAllIncome")
	public ResponseEntity<List<Income>> loadAllIncomes() {
		try {
			List<Income> IncomeList = incomeService.doIncomeOpr(null, IncomeService.GET_ALL);
			return new ResponseEntity<List<Income>>(IncomeList,HttpStatus.OK);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
}
