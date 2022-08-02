package com.mb.api.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@PostMapping("/checkout/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@Valid @RequestBody PaymentInfoDto paymentInfoDto) throws StripeException
	{
		String paymentStr = checkoutService.createPaymentIntent(paymentInfoDto);
		return new ResponseEntity<>(paymentStr, HttpStatus.OK);
	}

	@PostMapping("/webhook")
	public ResponseEntity<String> handleStripePaymentDetails(HttpServletRequest request)
	{
		String responseMsg = checkoutService.handleStripePaymentDetails(request);
		return new ResponseEntity<>(responseMsg, HttpStatus.OK);
	}
}
