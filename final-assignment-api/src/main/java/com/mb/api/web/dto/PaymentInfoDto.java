package com.mb.api.web.dto;

public class PaymentInfoDto
{
		private String name;
		private String currency;
		private String successUrl;
		private String cancelUrl;
		private long amount;
		private long quantity;
		public String getName()
		{
			return name;
		}
		public String getCurrency()
		{
			return currency;
		}
		public String getSuccessUrl()
		{
			return successUrl;
		}
		public String getCancelUrl()
		{
			return cancelUrl;
		}
		public long getAmount()
		{
			return amount;
		}
		public long getQuantity()
		{
			return quantity;
		}
		
		
	
}
