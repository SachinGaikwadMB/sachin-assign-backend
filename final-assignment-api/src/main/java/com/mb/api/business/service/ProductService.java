package com.mb.api.business.service;

import java.util.List;
import com.mb.api.persistance.entity.Product;
import com.mb.api.web.dto.PlaceOrderDto;

public interface ProductService
{
	String saveProduct(PlaceOrderDto placeOrderDto);
	
	List<Product> getAllProducts();
}
