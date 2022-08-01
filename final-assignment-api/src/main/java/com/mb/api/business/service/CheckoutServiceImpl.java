package com.mb.api.business.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.mb.api.web.dto.PaymentInfoDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class CheckoutServiceImpl implements CheckoutService
{
	private static Gson gson = new Gson();

	public static void init()
	{
		Stripe.apiKey = "sk_test_51LPixVSIFJPCF6ONXO35jPcquZI5zIBomVxASDnGyzPFXH2RC87LqQAT8um2fF0PbzxIVSXGcfBaxaeJN4Rp9NEr00IkYpEyEd";
	}

	@Override
	public String createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException
	{
		init();

		// We create a stripe session parameters
		SessionCreateParams params = SessionCreateParams.builder()
				// We will use the credit card payment method
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(paymentInfoDto.getSuccessUrl())
				.setCancelUrl(paymentInfoDto.getCancelUrl())
				.addLineItem(
						SessionCreateParams.LineItem.builder()
								.setQuantity(paymentInfoDto.getQuantity())
								.setPriceData(SessionCreateParams.LineItem.PriceData.builder()
										.setCurrency(paymentInfoDto.getCurrency())
										.setUnitAmount(paymentInfoDto.getAmount())
		
										.setProductData(
												SessionCreateParams.LineItem.PriceData.ProductData
														.builder()
														.setName(paymentInfoDto.getName())
														.addImage("https://m.media-amazon.com/images/I/71fkE5LBc+L._SX569_.jpg")
														.build())
										.build())
								.build())
				.build();
		// create a stripe session
		Session session = Session.create(params);
		Map<String, String> responseData = new HashMap<>();
		// We get the sessionId and we putted inside the response data you can get more info from the session object
		responseData.put("id", session.getId());
		// We can return only the sessionId as a String
		return gson.toJson(responseData);
	}

}
