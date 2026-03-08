package com.afif.paymentsriskdemo.service;

import com.afif.paymentsriskdemo.dto.PaymentHistoryItem;
import com.afif.paymentsriskdemo.dto.PaymentSubmissionRequest;
import com.afif.paymentsriskdemo.dto.PaymentSubmissionResponse;
import com.afif.paymentsriskdemo.model.PaymentDecision;
import com.afif.paymentsriskdemo.model.PaymentTransaction;
import com.afif.paymentsriskdemo.repository.PaymentDecisionRepository;
import com.afif.paymentsriskdemo.repository.PaymentTransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDecisionService{
	
	private final PaymentTransactionRepository transactionRepository;
	private PaymentDecisionRepository decisionRepository;
	private final OpenAIDecisionService openAIDecisionService;
	private final ObjectMapper objectMapper;
	
	public PaymentDecisionService(PaymentTransactionRepository transactionRepository,
			PaymentDecisionRepository decisionRepository, OpenAIDecisionService openAIDecisionService,
			ObjectMapper objectMapper) {
		super();
		this.transactionRepository = transactionRepository;
		this.decisionRepository = decisionRepository;
		this.openAIDecisionService = openAIDecisionService;
		this.objectMapper = objectMapper;
	}
	
	public PaymentSubmissionResponse evaluatePayment(PaymentSubmissionRequest request) {
		PaymentTransaction transaction = new PaymentTransaction();
		transaction.setSender(request.getSender());
		transaction.setRecipient(request.getRecipient());
		transaction.setAmount(request.getAmount());
		transaction.setMemo(request.getMemo());
		transaction.setContext(request.getContext());
		
		transaction = transactionRepository.save(transaction);
		
		OpenAIDecisionService.AiDecisionResult aiDecision;
		aiDecision = openAIDecisionService.evaluate(transaction);
		
		PaymentDecision decision = new PaymentDecision();
		decision.setTransaction(transaction);
		decision.setApproved(aiDecision.approved);
		decision.setExplanation(aiDecision.explanation);
		decision.setRiskScore(aiDecision.riskScore);
		decision.setModelName(openAIDecisionService.getModelName());
		decision.setRawResponse(toJson(aiDecision));
		
		decision = decisionRepository.save(decision);
		
		transaction.setDecision(decision);

		return new PaymentSubmissionResponse(
				transaction.getId(),
				decision.getApproved(),
				decision.getExplanation(),
				decision.getRiskScore(),
				decision.getModelName(),
				decision.getCreatedAt()
		);
	
	}
	
	public List<PaymentHistoryItem> getHistory(){
		return transactionRepository.findAll()
				.stream()
				.filter(transaction -> transaction.getDecision() != null)
				.map(transaction -> new PaymentHistoryItem(
						transaction.getId(),
						transaction.getSender(),
						transaction.getRecipient(),
						transaction.getAmount(),
						transaction.getMemo(),
						transaction.getContext(),
						transaction.getDecision().getApproved(),
						transaction.getDecision().getExplanation(),
						transaction.getDecision().getRiskScore(),
						transaction.getDecision().getModelName(),
						transaction.getCreatedAt(),
						transaction.getDecision().getCreatedAt()
				))
				.toList();
	}
	
	private String toJson(OpenAIDecisionService.AiDecisionResult aiDecision) {
		try {
			return objectMapper.writeValueAsString(aiDecision);
		} catch(JsonProcessingException e) {
			throw new IllegalStateException("Unable to serialize AI deicison.", e);
		}
	}
	
	
}