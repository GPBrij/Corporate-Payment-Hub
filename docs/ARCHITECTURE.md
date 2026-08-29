# Architecture and two-dimensional metafield maps

## System context
```mermaid
flowchart LR
 Corporate[Corporate user] -->|REST / JSON| CPH[Corporate Payment Hub]
 Checker[Payment checker] -->|Decision| CPH
 CPH -->|JPA| DB[(H2 or PostgreSQL)]
 CPH -->|Mock screening| Sanctions[(Synthetic sanctions data)]
 CPH -->|Mock settlement| Gateway[Gateway simulator]
 M365[M365 learning layer] -->|Power Apps / Power Automate HTTP| CPH
```

## Metafield map
```text
ACTOR        CHANNEL       COMMAND       DOMAIN          CONTROL          STATE          EVIDENCE
Maker   ->   REST/M365 ->  Create    -> Payment      -> Validation   -> Draft       -> Audit
Maker   ->   REST/M365 ->  Submit    -> Workflow     -> State gate   -> Pending     -> Audit
Checker ->   REST/M365 ->  Decide    -> Approval     -> Maker-checker-> Approved    -> Approval
System  ->   Internal  ->  Screen    -> Compliance   -> Mock match   -> Queue/Reject-> Audit
Gateway ->   Internal  ->  Process   -> Settlement   -> State gate   -> Settled      -> Audit
```

## Payment state line
```mermaid
stateDiagram-v2
 [*] --> DRAFT
 DRAFT --> PENDING_APPROVAL: submit
 PENDING_APPROVAL --> COMPLIANCE_REVIEW: approve
 PENDING_APPROVAL --> REJECTED: reject
 COMPLIANCE_REVIEW --> REJECTED: sanctions hit
 COMPLIANCE_REVIEW --> QUEUED: clear
 QUEUED --> PROCESSING: gateway accepts
 PROCESSING --> SETTLED: mock settlement
```

## Sequence
```mermaid
sequenceDiagram
 actor Maker
 participant API
 participant DB
 actor Checker
 participant Screen as Compliance Mock
 participant Gateway as Settlement Mock
 Maker->>API: POST payment
 API->>DB: Save DRAFT + audit
 Maker->>API: POST submit
 API->>DB: PENDING_APPROVAL + audit
 Checker->>API: POST decision APPROVE
 API->>Screen: Screen beneficiary
 Screen-->>API: clear or hit
 API->>DB: QUEUED or REJECTED + audit
 API->>Gateway: POST process
 Gateway-->>API: mock settled
 API->>DB: SETTLED + audit
```

## Design decisions
- Modular monolith first: easier to learn and test, while preserving bounded domain areas.
- Finite-state workflow: makes invalid transitions explicit.
- H2 plus PostgreSQL: rapid learning locally and realistic persistence with Docker.
- REST interfaces: suitable for Power Apps/Power Automate integration and later service decomposition.

