package com.mb.api.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "url1")
	private String url1;
	
	@Column(name = "url2")
	private String url2;
	
	@Column(name = "url3")
	private String url3;
	
	@Column(name = "url4")
	private String url4;
	
	
	public Image() {}


	public Image(Long id, String url1, String url2, String url3, String url4)
	{
		super();
		this.id = id;
		this.url1 = url1;
		this.url2 = url2;
		this.url3 = url3;
		this.url4 = url4;
	}


	public Long getId()
	{
		return id;
	}


	public String getUrl1()
	{
		return url1;
	}


	public String getUrl2()
	{
		return url2;
	}


	public String getUrl3()
	{
		return url3;
	}


	public String getUrl4()
	{
		return url4;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public void setUrl1(String url1)
	{
		this.url1 = url1;
	}


	public void setUrl2(String url2)
	{
		this.url2 = url2;
	}


	public void setUrl3(String url3)
	{
		this.url3 = url3;
	}


	public void setUrl4(String url4)
	{
		this.url4 = url4;
	}
	
	
}
