package com.bitshammer.business.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	@Column(name="author_id")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String surName;
		
	@Temporal(TemporalType.DATE)
	private Date bornDate;
	
	@Temporal(TemporalType.DATE)
	private Date deathDate;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="book_author",
	inverseJoinColumns={@JoinColumn(name="book_id" ,referencedColumnName="book_id") },
	joinColumns={@JoinColumn(name="author_id", referencedColumnName="author_id")})	
	private List<Book> books;

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

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surName=");
		builder.append(surName);
		builder.append(", bornDate=");
		builder.append(bornDate);
		builder.append(", deathDate=");
		builder.append(deathDate);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Author)obj).getId().equals(this.getId());
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBookes(List<Book> books) {
		this.books = books;
	}
	
	

}
