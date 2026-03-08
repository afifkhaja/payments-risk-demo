Payments Risk Decision Demo



Author: Afif Khaja  

Date: 03.07.2026



Overview



A lightweight payments demo built with Java 17 and Spring Boot.  

Users submit a payment transaction and a short natural‑language

explanation.  



The backend sends the data to the OpenAI API (gpt 4o mini), which returns a

structured decision:

·	Approved / Denied

·	Explanation

·	Optional risk score



Transactions and AI decisions are stored in a file‑backed H2

database so results are auditable and viewable through a simple

history page.



Tech Stack

·	Java 17

·	Spring Boot

·	Spring Web

·	Spring Data JPA

·	H2 Database

·	OpenAI Java SDK

·	AWS EC2



Application Architecture



Controller → Service → OpenAI API → Repository → H2 Database



Goal

Demonstrate practical backend engineering skills including:

\- API design

\- Persistence

\- Cloud deployment

\- LLM‑driven decision logic in a payments workflow



Database Architecture (2 tables)



(1) payment\_transaction

---

id

sender

recipient

amount

memo

context

created\_at



(2) payment\_decision

---

id

transaction\_id

approved

explanation

risk\_score

model\_name

raw\_response

created\_at

