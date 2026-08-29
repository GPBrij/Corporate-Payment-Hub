# Test plan

| ID | Scenario | Expected outcome |
|---|---|---|
| T01 | Valid payment creation | 201 and DRAFT |
| T02 | Zero or negative amount | 400 validation error |
| T03 | Non-three-letter currency | 400 validation error |
| T04 | Unknown customer | 404 |
| T05 | Submit draft | PENDING_APPROVAL |
| T06 | Submit non-draft | 400 invalid state |
| T07 | Approve clear beneficiary | QUEUED |
| T08 | Reject payment | REJECTED with reason |
| T09 | Synthetic sanctions match | REJECTED with mock match reason |
| T10 | Process queued payment | SETTLED |
| T11 | Process unqueued payment | 400 invalid state |
| T12 | Concurrent update | optimistic-lock conflict handled by platform |

## Test-data rule
Use invented companies, names, references and account numbers. Do not copy data from an employer, bank, client or production system.
