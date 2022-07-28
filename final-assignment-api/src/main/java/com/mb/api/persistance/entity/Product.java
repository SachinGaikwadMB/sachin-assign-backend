package com.mb.api.persistance.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id", nullable = false)
	private Set<Image> image;
	
	public Product() {}

	public Product(Long id, String name, Double unitPrice, String description, Set<Image> image)
	{
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.description = description;
		this.image = image;
	}

	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public Double getUnitPrice()
	{
		return unitPrice;
	}

	public String getDescription()
	{
		return description;
	}

	public Set<Image> getImage()
	{
		return image;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setUnitPrice(Double unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setImage(Set<Image> image)
	{
		this.image = image;
	}
	
	
	
}
