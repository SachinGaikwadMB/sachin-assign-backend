package com.mb.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.api.persistance.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Integer>
{

}
