# M365 as the learning and orchestration layer

## Suggested pattern
```text
SharePoint communication site -> Power Apps canvas app -> Power Automate flow -> Java REST API
                                              |
                                              +-> SharePoint learning register / evidence
```

## SharePoint learning lists
Create these only for portfolio evidence and workflow visibility, not as the Java system of record:
- `CPH Learning Backlog`: RequirementId, title, status, acceptance criteria, evidence URL.
- `CPH Test Evidence`: ScenarioId, API, expected status, actual status, evidence attachment.
- `CPH Architecture Decisions`: ADR number, context, decision, consequences.

## Power Apps screens
- Dashboard: counts by returned payment status.
- New Payment: customer, beneficiary, amount, currency, reference and value date.
- Checker Queue: pending approvals, decision and comments.
- Payment Detail: state, rejection reason and timestamps.

## Power Automate flow outline
1. Power Apps triggers the flow with a JSON payload.
2. HTTP action calls the Java `/api/v1/payments` endpoint.
3. Parse JSON returns the payment ID and status.
4. Write non-sensitive test evidence to SharePoint.
5. Respond to Power Apps.

For a local API, use a safe development tunnel or host the container in a controlled Azure development environment. Never put production credentials, customer data, account details, or access tokens in the repository.

