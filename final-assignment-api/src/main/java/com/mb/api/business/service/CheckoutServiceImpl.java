package com.mb.api.business.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.mb.api.web.dto.PaymentInfoDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class CheckoutServiceImpl implements CheckoutService
{
	

	
	public static void init() {
		Stripe.apiKey = "sk_test_51LPixVSIFJPCF6ONXO35jPcquZI5zIBomVxASDnGyzPFXH2RC87LqQAT8um2fF0PbzxIVSXGcfBaxaeJN4Rp9NEr00IkYpEyEd";
	}

	@Override
	public PaymentIntent createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException
	{	
		init();
		
		List<Object> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");
		
		Map<String, Object> params = new HashMap<>();
		params.put("amount", paymentInfoDto.getAmount());
		params.put("currency", paymentInfoDto.getCurrency());
		params.put("payment_method_types", paymentMethodTypes);
		
		return  PaymentIntent.create(params);
	}

}
