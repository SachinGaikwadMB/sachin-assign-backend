package com.mb.api.web.dto;

import javax.validation.constraints.NotBlank;

public class PaymentInfoDto
{
		@NotBlank
		private String name;
		
		@NotBlank
		private String currency;
		
		@NotBlank
		private String successUrl;
		
		@NotBlank
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
