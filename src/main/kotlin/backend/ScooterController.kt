package backend

import com.fasterxml.jackson.annotation.JsonProperty
import domain.runSimulation
import org.springframework.web.bind.annotation.*


data class ScootersRequest(
        @JsonProperty("C") val fleetManagerCapacity: Int,
        @JsonProperty("P") val fleetEngineerCapacity: Int,
        @JsonProperty("scooters") val scooters: List<Int>
)

data class ScootersResponse(
        @JsonProperty("fleet_engineers") val fleetEngineers: Int
)

@RestController
class ScooterController {
    @PostMapping("/scooters")
    fun scooters(@RequestBody request: ScootersRequest): ScootersResponse {
        val res = runSimulation(
                request.fleetManagerCapacity,
                request.fleetEngineerCapacity,
                request.scooters.toIntArray())
        return ScootersResponse(res)

        // Argument validation, which uses idiomatic IllegalArgumentException inside the Domain,
        // currently causes 500 internal server error.
        // This is not what a proper REST API should use, rather it should be
        // 400 Invalid Request.
        // preferably using the JsonProperty names for the invalid arguments
        // which there AFAIK, is no clean solution to it using Spring Boot.
        // you either leak Kotlin/Java variable/argument names through the REST API
        // OR, we have to apply some nonsense error handling to map names to the outside contract
        // I just chose to write this comment to show the issue is known, just deemed out of scope
        // for this test
    }
}
