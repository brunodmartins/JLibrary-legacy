package com.bitshammer.business.domain;

import javax.persistence.Embeddable;

/**
 * Class that represents a phone
 * 
 * @author Bruno
 *
 */
@Embeddable
public class Phone {
	
	//DDD
	private String ddd;
	 
	//Number
	private String phoneNumber;
	
	/**
	 * Constructor that receives a number
	 * formatted
	 */
	public Phone(String number) {
		ddd = number.substring(0, 3);
		phoneNumber = number.substring(4);
	}
	
	/**
	 * Default constructor
	 */
	public Phone(){
		
	}
	
	/**
	 * get a number formatted
	 * 
	 * @return A number formatted (999)9999-9999 or (999)9.9999-9999
	 */
	public String getFormatted(){
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(ddd);
		builder.append(")");
		if(phoneNumber.length() == 8){
			builder.append(phoneNumber.substring(0, 4));
			builder.append("-");
			builder.append(phoneNumber.substring(4));
		} else {
			builder.append(phoneNumber.substring(0, 1));
			builder.append(".");
			builder.append(phoneNumber.substring(1, 5));
			builder.append("-");
			builder.append(phoneNumber.substring(5));
		}		
		return builder.toString();
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
