package com.mb.api.business.service;

import com.mb.api.web.dto.PaymentInfoDto;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService
{
	PaymentIntent createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException;
}
