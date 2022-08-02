package com.mb.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.api.persistance.entity.SuccessPaymentData;

public interface SuccessPaymentRepository extends JpaRepository<SuccessPaymentData, Integer>
{

}
