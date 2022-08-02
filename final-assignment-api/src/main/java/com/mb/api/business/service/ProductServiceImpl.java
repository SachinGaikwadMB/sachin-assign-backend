package com.mb.api.business.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mb.api.business.exception.CustomException;
import com.mb.api.constant.ErrorCode;
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
			throw new CustomException("Unable Save Data !", ErrorCode.INTERNAL_SERVER_ERROR);
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
			throw new CustomException("Unable fetched Data !", ErrorCode.INTERNAL_SERVER_ERROR);
		}
		

	}

}
