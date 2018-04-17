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
  -d '{
  "C":12,
  "P":5,
  "scooters":[15, 10]
}'
```
