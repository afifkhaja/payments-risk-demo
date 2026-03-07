# Payments Risk Decision Demo

**Author:** Afif Khaja\
**Date:** 03.07.2026

## Overview

A lightweight payments demo built with **Java 17 and Spring Boot**.\
Users submit a payment transaction and a short natural‑language
explanation.\
The backend sends the data to the **OpenAI API**, which returns a
structured decision:

-   Approved / Denied
-   Explanation
-   Optional risk score

Transactions and AI decisions are stored in a **file‑backed H2
database** so results are auditable and viewable through a simple
history page.

## Tech Stack

-   Java 17
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   H2 Database
-   OpenAI Java SDK
-   AWS EC2

## Architecture

Controller → Service → OpenAI API → Repository → H2 Database

## Goal

Demonstrate practical backend engineering skills including: - API
design - Persistence - Cloud deployment - LLM‑driven decision logic in a
payments workflow
