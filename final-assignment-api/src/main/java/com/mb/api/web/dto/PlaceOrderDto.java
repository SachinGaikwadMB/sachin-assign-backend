package com.mb.api.web.dto;

import java.util.Set;
import com.mb.api.persistance.entity.Image;

public class PlaceOrderDto
{
	private String name;
	
	private Double unitPrice;
	
	private String description;
	
	private Set<Image> image;

	
	public PlaceOrderDto() {}


	public PlaceOrderDto(String name, Double unitPrice, String description, Set<Image> image)
	{
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.description = description;
		this.image = image;
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
		
}
