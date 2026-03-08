package com.afif.paymentsriskdemo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_decision")
public class PaymentDecision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "transaction_id", nullable = false, unique = true)
	private PaymentTransaction transaction;
	
	@Column(nullable = false)
	private Boolean approved;
	
	@Lob
	@Column(nullable = false)
	private String explanation;
	
	private Integer riskScore;
	
	@Column(nullable = false)
	private String modelName;
	
	@Lob
	@Column(nullable = false)
	private String rawResponse;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	// Getters and setters
	
	public PaymentTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(PaymentTransaction transaction) {
		this.transaction = transaction;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Integer getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(Integer riskScore) {
		this.riskScore = riskScore;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modellName) {
		this.modelName = modellName;
	}

	public String getRawResponse() {
		return rawResponse;
	}

	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

}