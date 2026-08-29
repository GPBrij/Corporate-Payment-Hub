# Requirements Baseline

## Purpose
A safe, synthetic learning platform demonstrating the end-to-end corporate payment lifecycle. It does not connect to a bank, payment rail, SWIFT, real sanctions source, or customer data.

## Actors
- Maker: captures and submits payments.
- Checker: approves or rejects under maker-checker control.
- Compliance service: performs a mock beneficiary/country match.
- Payment gateway: simulates queueing and settlement.
- Auditor: reviews immutable-style audit records.

## Functional requirements
- FR-001 Maintain corporate customers.
- FR-002 Maintain beneficiaries.
- FR-003 Capture a future-or-current-dated credit transfer with positive amount and ISO-style three-letter currency code.
- FR-004 Submit a draft payment for approval.
- FR-005 Record approval or rejection and comments.
- FR-006 Screen approved payments against clearly labelled synthetic sanctions data.
- FR-007 Queue clear payments and simulate settlement.
- FR-008 Expose payment status through REST.
- FR-009 Audit creation, submission, decision, screening and settlement.
- FR-010 Reject invalid state transitions.

## Non-functional requirements
- NFR-001 Java 21 and Spring Boot.
- NFR-002 REST/JSON interfaces versioned under `/api/v1`.
- NFR-003 Validation at the API boundary.
- NFR-004 Optimistic locking on payments.
- NFR-005 Health and metrics endpoints.
- NFR-006 No secrets or real personal/payment data committed.
- NFR-007 CI build on every push and pull request.
- NFR-008 PostgreSQL production-like profile; H2 local learning profile.

## Out of scope for v1
Real fund movement, real fraud scoring, bank-specific ISO 20022 conformance, SWIFT connectivity, real AML/KYC, exchange rates, fees, authentication, encryption key management and production resilience.

## Acceptance path
Create customer -> create beneficiary -> create payment -> submit -> approve -> screen -> queue -> process -> settled. A synthetic sanctions match ends in rejected status.
