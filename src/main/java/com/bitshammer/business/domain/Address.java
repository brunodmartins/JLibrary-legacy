package com.bitshammer.business.domain;

import javax.persistence.Embeddable;

/**
 * Class that represent an address
 * @author Bruno
 *
 */
@Embeddable
public class Address {
	
	private String zipCode;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String uf;
	
	private String information;
	
	private Long number;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	
	

}
