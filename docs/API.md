# API execution guide

Base URL: `http://localhost:8080/api/v1`

## 1. Create customer
```bash
curl -s -X POST http://localhost:8080/api/v1/customers -H 'Content-Type: application/json' -d '{"companyName":"Ubuntu Manufacturing","registrationNumber":"SYNTH-001","riskRating":"LOW","active":true}'
```

## 2. Create beneficiary
```bash
curl -s -X POST http://localhost:8080/api/v1/beneficiaries -H 'Content-Type: application/json' -d '{"name":"Synthetic Supplier","accountNumber":"0000000000","bankCode":"MOCKZAJJ","countryCode":"ZA"}'
```

## 3. Create payment
Replace IDs and value date.
```bash
curl -s -X POST http://localhost:8080/api/v1/payments -H 'Content-Type: application/json' -H 'X-Actor: patrick.maker' -d '{"customerId":"CUSTOMER_ID","beneficiaryId":"BENEFICIARY_ID","amount":1250.00,"currency":"ZAR","clientReference":"INV-SYNTH-1001","valueDate":"2026-08-31"}'
```

## 4. Submit
```bash
curl -s -X POST http://localhost:8080/api/v1/payments/PAYMENT_ID/submit -H 'X-Actor: patrick.maker'
```

## 5. Approve
```bash
curl -s -X POST http://localhost:8080/api/v1/payments/PAYMENT_ID/decision -H 'Content-Type: application/json' -d '{"actor":"demo.checker","decision":"APPROVE","comments":"Synthetic test approved"}'
```

## 6. Process
```bash
curl -s -X POST http://localhost:8080/api/v1/payments/PAYMENT_ID/process -H 'X-Actor: mock.gateway'
```

## 7. Query
```bash
curl -s http://localhost:8080/api/v1/payments
curl -s http://localhost:8080/actuator/health
```

