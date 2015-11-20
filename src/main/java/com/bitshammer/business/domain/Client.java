package com.bitshammer.business.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class that represent an client
 * @author Bruno
 *
 */
@Entity
public class Client {
	
	@Id
	@GeneratedValue
	@Column(name="client_id")
	private Long id;
	
	@Column
	private String name;
	
	@Column(length=50)
	private String email;
	
	@Embedded
	private Phone phone;
	
	@Embedded
	private Address adress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	
	
}
