package com.bitshammer.business.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * Class representing a book
 * 
 * @author Bruno
 *
 */
@Entity
public class Book {

	@Id
	@GeneratedValue
	@Column(name = "book_id")
	private Long id;

	@Column(length = 200)
	private String title;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = {
			@JoinColumn(name = "book_id", referencedColumnName = "book_id") }, inverseJoinColumns = {
					@JoinColumn(name = "author_id", referencedColumnName = "author_id") })
	private List<Author> author;

	@Column(length = 13)
	private String isbn;

	@Column(length = 4)
	private Integer pagesNumbers;

	@Column
	private String description;

	@Enumerated(EnumType.ORDINAL)
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getPagesNumbers() {
		return pagesNumbers;
	}

	public void setPagesNumbers(Integer pagesNumbers) {
		this.pagesNumbers = pagesNumbers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", isbn=");
		builder.append(isbn);
		builder.append(", pagesNumbers=");
		builder.append(pagesNumbers);
		builder.append(", description=");
		builder.append(description);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}

}
