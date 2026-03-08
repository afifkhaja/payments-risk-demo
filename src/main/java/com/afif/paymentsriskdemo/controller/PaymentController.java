package com.afif.paymentsriskdemo.controller;

import com.afif.paymentsriskdemo.dto.PaymentHistoryItem;
import com.afif.paymentsriskdemo.dto.PaymentSubmissionRequest;
import com.afif.paymentsriskdemo.dto.PaymentSubmissionResponse;
import com.afif.paymentsriskdemo.service.PaymentDecisionService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	private final PaymentDecisionService paymentDecisionService;
	
	public PaymentController(PaymentDecisionService paymentDecisionService) {
		this.paymentDecisionService = paymentDecisionService;
	}
	
	@PostMapping("/decide")
	public PaymentSubmissionResponse decide(@Valid @RequestBody PaymentSubmissionRequest request) {
		return paymentDecisionService.evaluatePayment(request);
	}
	
	@GetMapping("/history")
	public List<PaymentHistoryItem> history(){
		return paymentDecisionService.getHistory()
				.stream()
				.sorted(Comparator.comparing(PaymentHistoryItem::getDecisionAt).reversed())
				.toList();
	}

}
