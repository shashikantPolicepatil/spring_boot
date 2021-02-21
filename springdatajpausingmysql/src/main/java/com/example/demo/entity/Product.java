/**
 * 
 */
package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hp
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString		
public class Product {
	
	public Product(String pCode,Double pCost,String vendor,Date DateA,Date DateB,Date DateC) {
		this.pcode=pCode;
		this.pcost=pCost;
		this.pvendor=vendor;
		this.DateA=DateA;
		this.DateB=DateB;
		this.DateC=DateC;
	}

	public Product(byte[] img,char[] data) {
		this.img = img;
		this.data = data;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String pcode;
	private Double pcost;
	private String pvendor;
	
	@Temporal(TemporalType.DATE)
	private Date DateA;	
	@Temporal(TemporalType.TIME)
	private Date DateB;
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateC;
	
	@Lob
	private byte[] img;
	
	@Lob
	private char[] data;
}
