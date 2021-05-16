/**
 * 
 */
package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

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
@Entity
@Table(name="Income")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Credit")
	private BigDecimal credit;
	
	@Column(name="Income_Date")
	@Temporal(TemporalType.DATE)
	private Date incomeDate;
	
	@OneToOne
	@JoinColumn(name="expense_category_id",referencedColumnName = "id")
	private ExpenseCategory category;
}
