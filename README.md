# Corporate Payment Hub

A portfolio-grade **mock CIB corporate payment platform** built in Java. It demonstrates requirements-to-code traceability, maker-checker approval, synthetic sanctions screening, state management, audit evidence, REST integration, Docker and CI.

> **Safety:** This project does not move money and is not connected to a bank, SWIFT, a payment rail or a real sanctions source. Use synthetic data only.

## Visual journey
```text
REQUIREMENT -> API -> DOMAIN RULE -> DATABASE -> TEST -> CI -> M365 EVIDENCE
     |          |         |             |          |      |         |
   FR-xxx     REST      State gate    H2/Postgres  Txx   GitHub   SharePoint
```

## Stack
Java 21, Spring Boot 4.1.1, Maven, Spring Web, JPA, Bean Validation, H2, PostgreSQL, Docker and GitHub Actions.

## Run locally
```bash
mvn spring-boot:run
```
Open the health endpoint at `http://localhost:8080/actuator/health`. The H2 console is at `http://localhost:8080/h2-console` using JDBC URL `jdbc:h2:mem:cph`, user `sa`, and a blank password.

## Run with Docker
```bash
docker compose up --build
```

## Execute the journey
Follow [`docs/API.md`](docs/API.md). Read the requirements, architecture, test plan and M365 integration guide in [`docs`](docs/).

## Repository structure
```text
src/main/java     application and domain code
src/test/java     automated tests
docs              requirements, diagrams, API, M365 and test plan
.github/workflows continuous integration
```

## Current capabilities
- Customer, beneficiary and synthetic sanction reference data
- Draft payment capture and validation
- Maker-checker submission and decision
- Mock sanctions screening
- Queue and simulated settlement
- Audit trail and optimistic locking
- H2 local mode and PostgreSQL Docker mode

## Planned portfolio increments
1. Microsoft Entra ID OIDC and role-based access.
2. ISO 20022 `pain.001` generation and XSD validation using an officially selected message version.
3. Kafka events with outbox pattern and idempotency keys.
4. WireMock integration tests and contract tests.
5. Power Apps front end and Power Automate connector.
6. Azure deployment, Key Vault, Application Insights and IaC.

## Important design boundary
ISO 20022 XML is deliberately not claimed as conformant in v1. A real implementation must select an exact message definition, official schema, market-practice rules and bank/channel profile, then test against that target.

## Author
Patrick Brijraj

