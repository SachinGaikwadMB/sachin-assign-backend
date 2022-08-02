package com.mb.api.business.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.mb.api.persistance.entity.SuccessPaymentData;
import com.mb.api.persistance.repository.SuccessPaymentRepository;
import com.mb.api.web.dto.PaymentInfoDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class CheckoutServiceImpl implements CheckoutService
{
	@Autowired
	private SuccessPaymentRepository successPaymentRepository;

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

	@Override
	public String handleStripePaymentDetails(HttpServletRequest request)
	{
		String sigHeader = request.getHeader("Stripe-Signature");
		Event event = null;
		try
		{
			String payload = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			event = Webhook.constructEvent(payload, sigHeader, "whsec_b05b27140b30474fc22fe68e97022352e024095331103476b1bc4105445f61ca");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if ("charge.succeeded".equals(event.getType()))
		{
			SuccessPaymentData successDetails = new SuccessPaymentData();

			EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
			StripeObject stripeObject = null;
			if (dataObjectDeserializer.getObject().isPresent())
			{
				stripeObject = dataObjectDeserializer.getObject().get();
			}
			Charge charge = (Charge) stripeObject;

			successDetails.setEmail(charge.getBillingDetails().getEmail());
			successDetails.setName(charge.getBillingDetails().getName());
			successDetails.setAmount(charge.getAmount() / 100);
			successDetails.setTransctionId(charge.getBalanceTransaction());

			successPaymentRepository.save(successDetails);
		}
		return "Your Order Placed Successfully !";
	}

}
