package com.afif.paymentsriskdemo.repository;

import com.afif.paymentsriskdemo.model.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long>{

}
