package com.pluralsight.storebook.model;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity
public class Book {

	@Id @GeneratedValue
	private long id;
	
	@Column(length = 200)
	@NotNull
	@Size(min = 1, max = 200)
	private String title;
	
	@Size(max = 1000)
	@Column(length = 1000)
	private String description;
	
	@Size(min = 1)
	@Column(name = "unit_cost")
	private float unitCost;
	
	@Column(length = 50)
	@NotNull
	@Size(min = 1, max = 50)
	private String isbn;
	
	@Column(name = "publication_date")
	@Temporal(TemporalType.DATE)
	@Past
	private Date publicationDate;
	
	private Integer nbOfPages;
	
	private String imgUrl;
	
	private Language language;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getNbOfPages() {
		return nbOfPages;
	}

	public void setNbOfPages(Integer nbOfPages) {
		this.nbOfPages = nbOfPages;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", unitCost=" + unitCost
				+ ", isbn=" + isbn + ", publicationDate=" + publicationDate + ", nbOfPages=" + nbOfPages + ", imgUrl="
				+ imgUrl + ", language=" + language + "]";
	}
	
	
	
	
}
