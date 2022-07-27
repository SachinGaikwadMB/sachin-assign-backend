package com.mb.api.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "checkout")
public class Checkout
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}
