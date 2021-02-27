/**
 * 
 */
package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String pcode;
	private Double pcost;
	private String pmodel;
	
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
	
	@ManyToOne
	//name is option, if not provided default format is hasVeriableName_childTablePKColumnName e.g. vendor_vid_col
	private Vendor vendor; //HAS-A relation
	
	public Product(String pCode,Double pCost,String vendor,Date DateA,Date DateB,Date DateC) {
		this.pcode=pCode;
		this.pcost=pCost;
		this.DateA=DateA;
		this.DateB=DateB;
		this.DateC=DateC;
	}

	public Product(String pcode,Double pcost,String pmodel,Vendor vendor) {
		this.pcode = pcode;
		this.pmodel = pmodel;
		this.pcost = pcost;
		this.vendor = vendor;
	}
	
	public Product(byte[] img,char[] data) {
		this.img = img;
		this.data = data;
	}

}
