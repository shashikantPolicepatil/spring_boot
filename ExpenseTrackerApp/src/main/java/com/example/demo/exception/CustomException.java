/**
 * 
 */
package com.example.demo.exception;


/**
 * @author hp
 *
 */
public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String message;
	
	public CustomException() {
		super();
	}
	
	public CustomException(String message) {
		super(message);
		this.message=message;
	}

}
