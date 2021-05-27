/**
 * 
 */
package com.example.demo.resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Any;
import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.IncomeRepository;
import com.example.demo.util.ExpenseUtility;

/**
 * @author hp
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class UtilityResource {
	
	private ExpenseRepository expenseRepository;
	private IncomeRepository incomeRepository;
	
	@Autowired
	public UtilityResource(ExpenseRepository expenseRepository,IncomeRepository incomeRepository) {
		this.expenseRepository = expenseRepository;
		this.incomeRepository = incomeRepository;
	}

	@SuppressWarnings("deprecation")
	@GetMapping("/dashboarddata/{month}")	
	public ResponseEntity<Map<String,Object>> getDashBoardData(@PathVariable Integer month) {
		BigDecimal totalDebitAmount = BigDecimal.ZERO;
		BigDecimal totalCreditAmount = BigDecimal.ZERO;
		Map<String,Object> retData = new HashMap<String,Object>();
		List<Any> expenseByCateList = new ArrayList<>();
		List<Expense> expenseList = new ArrayList<>();
		List<Income> incomeList = new ArrayList<>();
		if(month.intValue()==0) {
			expenseList = expenseRepository.findAll();
			incomeList = incomeRepository.findAll();
		} else {
			expenseList = expenseRepository.findByMonth(ExpenseUtility.getMonth(month-1));
			incomeList = incomeRepository.findByMonth(ExpenseUtility.getDateByMonth(month));
		}
		
		IntSummaryStatistics expenseStats = getStats(expenseList.stream().map(expense->expense.getAmount().intValue())
				.collect(Collectors.toList()));
		IntSummaryStatistics incomeStats = getStats(incomeList.stream().map(income->income.getCredit().intValue())
				.collect(Collectors.toList()));
				
		totalDebitAmount = new BigDecimal(expenseStats.getSum());
		totalCreditAmount = new BigDecimal(incomeStats.getSum());

		Map<String, List<Expense>> expenseByCate = expenseList.stream().collect(Collectors.groupingBy(expense->expense.getCategory().getCategoryCode()));
		for (Map.Entry<String, List<Expense>> entry : expenseByCate.entrySet()) {
		      System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
		      expenseStats = getStats(entry.getValue().stream().map(expense->expense.getAmount().intValue()).collect(Collectors.toList()));
		      expenseByCateList.add(new Any(entry.getKey(),new Double(expenseStats.getSum()),getPerUsed(expenseStats.getSum(),totalCreditAmount.doubleValue())));
		 }
		retData.put("debitAmount", totalDebitAmount!=null?totalDebitAmount.setScale(2, BigDecimal.ROUND_HALF_UP):BigDecimal.ZERO);
		retData.put("creditAmount", totalCreditAmount!=null?totalCreditAmount.setScale(2, BigDecimal.ROUND_HALF_UP):BigDecimal.ZERO);
		retData.put("per",getPerUsed(totalDebitAmount.doubleValue(),totalCreditAmount.doubleValue()));
		retData.put("balance",totalCreditAmount.subtract(totalDebitAmount));
		retData.put("expenseByCate",expenseByCate);
		retData.put("amountByCate",expenseByCateList);
		
		getChartData(retData,expenseByCateList);
		
		return new ResponseEntity<Map<String,Object>>(retData,HttpStatus.OK);
	}
	
	private IntSummaryStatistics getStats(List<Integer> list) {
		return list.stream().mapToInt((amount)->amount).summaryStatistics();
	}
	
	private double getPerUsed(double amt,double creditedAmount) {
		return (100/creditedAmount)*amt;
	}
	
	private Map getChartData(Map<String,Object> map,List<Any> expenseByCateList) {
		List<String> labels = new ArrayList<>();
		List<Double> series = new ArrayList<>();
		map.put("display", false);
		expenseByCateList.stream().forEach(any->{
			labels.add(any.getField());
			series.add(any.getValue());
			map.put("display", true);
		});
		map.put("series", series);
		map.put("labels", labels);
		map.put("options.chart.width", 380);
		map.put("options.chart.type", "pie");
		return map;
	}
}

