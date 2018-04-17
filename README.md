# scooters

Running the application:

```text
./gradlew bootRun
```

The API exists at:
```text
POST http://localhost:8080/scooters
```

Content type:
```
application/json
```

Payload
```json
{
  "C":12,
  "P":5,
  "scooters":[15, 10]
}
```

cURL
```
curl -X POST \
  http://localhost:8080/scooters \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 331aac7c-84bc-cc58-f08e-3819e9ae68ab' \
  -d '{
  "C":12,
  "P":5,
  "scooters":[15, 10]
}'
```
