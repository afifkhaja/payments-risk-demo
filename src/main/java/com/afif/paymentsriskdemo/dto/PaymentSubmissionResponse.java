package com.afif.paymentsriskdemo.dto;

import java.time.LocalDateTime;

public class PaymentSubmissionResponse {

	// Instance variables
	
	private Long transactionId;
	private Boolean approved;
	private String explanation;
	private Integer riskScore;
	private String modelName;
	private LocalDateTime createdAt;
	
	// Constructor
	
	public PaymentSubmissionResponse(Long transactionId, Boolean approved, String explanation, Integer riskScore,
			String modelName, LocalDateTime createdAt) {
		super();
		this.transactionId = transactionId;
		this.approved = approved;
		this.explanation = explanation;
		this.riskScore = riskScore;
		this.modelName = modelName;
		this.createdAt = createdAt;
	}
	
	// Getters
	
	public Long getTransactionId() {
		return transactionId;
	}
	public Boolean getApproved() {
		return approved;
	}
	public String getExplanation() {
		return explanation;
	}
	public Integer getRiskScore() {
		return riskScore;
	}
	public String getModelName() {
		return modelName;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
}
