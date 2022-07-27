package com.mb.api.business.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.mb.api.persistance.repository.CheckoutRepository;
import com.mb.api.web.dto.PaymentInfoDto;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class CheckoutServiceImpl implements CheckoutService
{
	@Autowired
	private CheckoutRepository checkoutRepository;

	@Value("${stripe.key.secret}")
	private String secretKey;

	@Override
	public PaymentIntent createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException
	{
		List<Object> paymentMethodTypes = new ArrayList<>();
		
		paymentMethodTypes.add("card");
		
		Map<String, Object> params = new HashMap<>();
		params.put("amount", paymentInfoDto.getAmount());
		params.put("currency", paymentInfoDto.getCurrency());
		params.put("payment_method_types", paymentMethodTypes);
		
		return  PaymentIntent.create(params);
	}

}
