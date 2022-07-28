package com.mb.api.business.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mb.api.persistance.entity.Product;
import com.mb.api.persistance.repository.ProductRepository;
import com.mb.api.web.dto.PlaceOrderDto;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String saveProduct(PlaceOrderDto placeOrderDto)
	{
		Product product = modelMapper.map(placeOrderDto, Product.class);
		try {
		productRepository.save(product);
		}catch (Exception ex) {
			//TODO: Handle exception
		}
		return "Your Order placed successfully !";
	}

	@Override
	public List<Product> getAllProducts()
	{
		
		try
		{
			return  productRepository.findAll();
		}
		catch (Exception e)
		{
			throw new  RuntimeException("Unable to fetch data, Please try again later.");
		}
		

	}

}
