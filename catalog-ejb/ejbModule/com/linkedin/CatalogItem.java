package com.linkedin;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOG_TABLE")
public class CatalogItem {

	@Id
	@Column(name = "CATALOG_ITEM_ID")
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long itemId;

	private String name;

	private String manufacturer;

	private String description;

	private LocalDate availableDate;
	
	 
	public CatalogItem() {
		super();
	}

	public CatalogItem(String name, String manufacturer, String description, LocalDate availableDate) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.availableDate = availableDate;
	}

	public Long getItemId() {
		return itemId;
	}
	
	
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}



	@Override
	public String toString() {
		return "CatalogItem [itemId=" + itemId + ", name=" + name + ", manufacturer=" + manufacturer + ", description="
				+ description + ", availableDate=" + availableDate + "]";
	}
	
	 

}
