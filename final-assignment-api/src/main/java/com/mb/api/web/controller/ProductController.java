package com.mb.api.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mb.api.business.service.ProductService;
import com.mb.api.persistance.entity.Product;
import com.mb.api.web.dto.PlaceOrderDto;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController
{
	
	//TODO : Exception handling and validation
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody PlaceOrderDto placeOrderDto) {
		String responseMessage = productService.saveProduct(placeOrderDto);
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}
		

}
