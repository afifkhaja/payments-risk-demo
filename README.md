# AI-Assisted Payment Risk Decision Demo

**Tech:** Java 17 · Spring Boot · AWS EC2 · OpenAI API · H2 Database

## Overview

This demo simulates an **AI‑assisted payment risk decision system**
similar to modern fraud / payment review platforms.

A user submits a payment transaction and a natural‑language explanation
through a simple web UI. The backend sends the request to an LLM, which
produces a structured risk decision.

The system stores both the transaction and the AI decision for auditing.

## Architecture

User (HTML UI)
→ Spring Boot Controller
→ OpenAI API (LLM decision engine)
→ Risk Decision (approve / deny + score + explanation)
→ H2 Database persistence

## Features

-   Java 17 + Spring Boot backend
-   AI‑generated payment risk decisions
-   Structured decision output (approve / deny + risk score)
-   File‑backed H2 database for auditability
-   Simple embedded HTML UI
-   Deployable as a single executable JAR

## Deployment

The application is deployed to **AWS EC2**:

1.  Package Spring Boot app as executable JAR
2.  Launch EC2 instance
3.  Install Java 17 (Amazon Corretto)
4.  Upload JAR and `.env` with OpenAI API key
5.  Start app with:

```{=html}
nohup java -jar payment-risk-demo.jar
```

Application is available at:

    http://<EC2_PUBLIC_IP>:8080

## Purpose

This project demonstrates integration of:

-   **Java / Spring Boot backend systems**
-   **Cloud deployment on AWS**
-   **AI-assisted decision systems**
-   **Simple but auditable risk workflows**

Built as a fast end‑to‑end prototype to illustrate how LLMs can assist
payment and fraud decision pipelines.
