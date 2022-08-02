package com.mb.api.business.service;

import javax.servlet.http.HttpServletRequest;
import com.mb.api.web.dto.PaymentInfoDto;
import com.stripe.exception.StripeException;

public interface CheckoutService
{
	String createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException;
	String handleStripePaymentDetails(HttpServletRequest request);
}
