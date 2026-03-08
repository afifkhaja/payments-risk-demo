package com.afif.paymentsriskdemo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class PaymentSubmissionRequest {

	// Instance variables
	
	@NotBlank
	private String sender;
	
	@NotBlank
	private String recipient;
	
	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal amount;
	
	@NotBlank private String memo;
	
	@NotBlank
	private String context;
	
	// Getters and setters

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	
}
