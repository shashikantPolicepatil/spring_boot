/**
 * 
 */
package com.example.demo.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ExpenseCategory;
import com.example.demo.exception.CustomException;
import com.example.demo.service.CategoryService;

/**
 * @author hp
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/category")
public class CategoryResourse {

	private CategoryService categoryService;

	@Autowired
	public CategoryResourse(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/addCategory")
	public ResponseEntity<ExpenseCategory> addCategory(@RequestBody ExpenseCategory expenseCategory) {
		try {
			expenseCategory = categoryService.doCategoryOpr(expenseCategory, CategoryService.ADD).get(0);
			return new ResponseEntity<ExpenseCategory>(expenseCategory, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}

	}

	@PostMapping("/editCategory")
	public ResponseEntity<ExpenseCategory> editCategory(@RequestBody ExpenseCategory expenseCategory) {
		try {
			expenseCategory = categoryService.doCategoryOpr(expenseCategory, CategoryService.EDIT).get(0);
			return new ResponseEntity<ExpenseCategory>(expenseCategory, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/removeCategory")
	public ResponseEntity<String> removeCategory(@RequestBody ExpenseCategory expenseCategory) {
		try {
			expenseCategory = categoryService.doCategoryOpr(expenseCategory, CategoryService.DELETE).get(0);
			return new ResponseEntity<String>("Removed successfully", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@GetMapping("/loadCategories")
	public ResponseEntity<List<ExpenseCategory>> loadCategories(@RequestParam(required = false,
																				defaultValue = "1") Integer page ) {
		List<ExpenseCategory> list = categoryService.doCategoryOpr(new ExpenseCategory(page,null,null), CategoryService.GET_ALL);
		//Map<String, Object> allCategory = categoryService.getAllCategory(new ExpenseCategory(page, null, null));
		return new ResponseEntity<List<ExpenseCategory>>(list, HttpStatus.OK);
	}
}
