/**
 * 
 */
package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hp
 *
 */
@Table(name = "Expense")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Amount",nullable = false)
	private BigDecimal amount;
	
	@Column(name = "Expense_Date",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date expenseDate;
	
	@Column(name = "Expense_Month",nullable = false)
	private String month;
	
	@OneToOne
	@JoinColumn(name="expense_category_id",referencedColumnName = "id")
	private ExpenseCategory category;
	
	
}
