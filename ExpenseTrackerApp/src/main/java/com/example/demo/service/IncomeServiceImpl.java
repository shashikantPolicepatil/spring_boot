/**
 * 
 */
package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Income;
import com.example.demo.repository.IncomeRepository;

/**
 * @author hp
 *
 */
@Service
public class IncomeServiceImpl implements IncomeService {
	
	@Autowired
	private IncomeRepository incomeRepository;

	@Override
	public List<Income> doIncomeOpr(Income income, String actionName) {
		switch(actionName) {
		case ADD:
			return Arrays.asList(incomeRepository.save(income));
		case EDIT:
			return Arrays.asList(incomeRepository.save(income));
		case GET_ALL:
			return incomeRepository.findAll(Sort.by("incomeDate"));
		case DELETE:
			incomeRepository.deleteById(income.getId());
		default:
			incomeRepository.findAll();
		}
		return null;
	}

}
