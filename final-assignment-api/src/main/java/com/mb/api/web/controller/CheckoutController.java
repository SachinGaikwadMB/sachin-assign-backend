package com.mb.api.web.controller;

import java.util.ArrayList;
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
import com.mb.api.business.service.CheckoutService;
import com.mb.api.web.dto.PaymentInfoDto;
import com.stripe.exception.StripeException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class CheckoutController
{
	@Autowired
	private CheckoutService checkoutService;
	
	@GetMapping("/test")
	public List<String> test() {
		List<String> list = new ArrayList<>();
		list.add("sachin");
		list.add("aman");
		list.add("amaresh");
		
		return list;
	}
	
	@PostMapping("/checkout/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoDto paymentInfoDto) throws StripeException
	{
		String  paymentStr = checkoutService.createPaymentIntent(paymentInfoDto);
		return new ResponseEntity<>(paymentStr, HttpStatus.OK);
	}

}
