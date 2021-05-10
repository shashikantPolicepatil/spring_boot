/**
 * 
 */
package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hp
 *
 */
@Table(name = "Expense_Category")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Category_Code",nullable = false)
	private String categoryCode;
	
	@Column(name="Category_Desc",nullable = false)
	private String categoryDesc;
}
