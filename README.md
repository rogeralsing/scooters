# Scooters

## Requirements

Gradle and Kotlin installations.

## Running

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

## Solution

### Domain Logic
[https://github.com/rogeralsing/scooters/blob/master/src/main/kotlin/testtask/scooters/ScooterService.kt](https://github.com/rogeralsing/scooters/blob/master/src/main/kotlin/testtask/scooters/ScooterService.kt)

### Tests
[https://github.com/rogeralsing/scooters/blob/master/src/test/kotlin//testtask/scooters/ScooterServiceTest.kt](https://github.com/rogeralsing/scooters/blob/master/src/test/kotlin//testtask/scooters/ScooterServiceTest.kt)

### Rest API
[https://github.com/rogeralsing/scooters/blob/master/src/main/kotlin/testtask/scooters/ScooterController.kt](https://github.com/rogeralsing/scooters/blob/master/src/main/kotlin/testtask/scooters/ScooterController.kt)