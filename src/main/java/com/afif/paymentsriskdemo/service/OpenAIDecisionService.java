package com.afif.paymentsriskdemo.service;

import com.afif.paymentsriskdemo.model.PaymentTransaction;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams;
import org.springframework.stereotype.Service;

@Service
public class OpenAIDecisionService {

	private static final String MODEL_NAME = "gpt-4o-mini";

	private OpenAIClient openAIClient = null;

	public OpenAIDecisionService(OpenAIClient openAIClient) {
		this.openAIClient = openAIClient;
	}

	public AiDecisionResult evaluate(PaymentTransaction transaction) {
		String prompt = buildPrompt(transaction);

		StructuredChatCompletionCreateParams<AiDecisionResult> params = ChatCompletionCreateParams.builder()
				.model(ChatModel.GPT_4O_MINI).addSystemMessage("""
						You are a payment risk analyst for a demo decisioning system.
						Review the transaction and return a cautious but practical decision.
						Approve normal low-risk consumer payments.
						Deny payments that appear fraudulent, coercive, illegal, manipulative, or highly suspicious.
						Keep the explanation concise and businesslike.
						The riskScore must be an integer from 0 to 100, where 100 is highest risk.
						""").addUserMessage(prompt).responseFormat(AiDecisionResult.class).build();

		return openAIClient.chat().completions().create(params).choices().stream()
				.flatMap(choice -> choice.message().content().stream()).findFirst()
				.orElseThrow(() -> new RuntimeException("OpenAI returned no decision."));

	}

	public String getModelName() {
		return MODEL_NAME;
	}

	private String buildPrompt(PaymentTransaction transaction) {
		return """
					Evaluate this payment transaction.

					Sender: %s
					Recipient: %s,
					Amount: %s
					Memo: %s
					Context: %s

					Return a structured decision object.
				""".formatted(transaction.getSender(), transaction.getRecipient(), transaction.getAmount(),
				transaction.getMemo(), transaction.getContext());
	}

	@JsonClassDescription("Structured payment risk decision for a single transaction.")
	public static class AiDecisionResult {

		@JsonPropertyDescription("True if the payment should be approved. False if it should be denied.")
		public boolean approved;

		@JsonPropertyDescription("Brief explanation for the decision in plain English.")
		public String explanation;

		@JsonPropertyDescription("Integer risk score from 0 to 100, where 100 is highest risk.")
		public int riskScore;

	}

}