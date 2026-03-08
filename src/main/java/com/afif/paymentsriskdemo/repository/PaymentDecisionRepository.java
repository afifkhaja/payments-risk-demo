package com.afif.paymentsriskdemo.repository;

import com.afif.paymentsriskdemo.model.PaymentDecision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDecisionRepository extends JpaRepository<PaymentDecision, Long> {

}