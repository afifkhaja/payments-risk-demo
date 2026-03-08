package com.afif.paymentsriskdemo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentHistoryItem {

	private Long transactionId;
	private String sender;
	private String recipient;
	private BigDecimal amount;
	private String memo;
	private String context;
	private Boolean approved;
	private String explanation;
	private Integer riskScore;
	private String modelName;
	private LocalDateTime submittedAt;
	private LocalDateTime decisionAt;
	
	public PaymentHistoryItem(Long transactionId, String sender, String recipient, BigDecimal amount, String memo,
			String context, Boolean approved, String explanation, Integer riskScore, String modelName,
			LocalDateTime submittedAt, LocalDateTime decisionAt) {
		super();
		this.transactionId = transactionId;
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
		this.memo = memo;
		this.context = context;
		this.approved = approved;
		this.explanation = explanation;
		this.riskScore = riskScore;
		this.modelName = modelName;
		this.submittedAt = submittedAt;
		this.decisionAt = decisionAt;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getMemo() {
		return memo;
	}

	public String getContext() {
		return context;
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

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public LocalDateTime getDecisionAt() {
		return decisionAt;
	}
	
}
