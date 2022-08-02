package com.mb.api.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "success_payment_data")
public class SuccessPaymentData
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name ;
	private String email;
	private Long amount;
	private String transctionId;
	
	public SuccessPaymentData() {}
	
	public SuccessPaymentData(Integer id, String name, String email, Long amount, String transctionId)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.amount = amount;
		this.transctionId = transctionId;
	}

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Long getAmount()
	{
		return amount;
	}

	public String getTransctionId()
	{
		return transctionId;
	}

	public void setAmount(Long amount)
	{
		this.amount = amount;
	}

	public void setTransctionId(String transctionId)
	{
		this.transctionId = transctionId;
	}
	
}
