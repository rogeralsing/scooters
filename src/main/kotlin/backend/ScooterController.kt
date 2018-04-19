package backend

import com.fasterxml.jackson.annotation.JsonProperty
import domain.runSimulation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


data class ScootersRequest(
        @JsonProperty("C") val fleetManagerCapacity: Int,
        @JsonProperty("P") val fleetEngineerCapacity: Int,
        @JsonProperty("scooters") val scooters: List<Int>
)

data class ScootersResponse(
        @JsonProperty("fleet_engineers") val fleetEngineers: Int)

@RestController
class ScooterController {
    @PostMapping("/scooters")
    fun scooters(@RequestBody request: ScootersRequest): ScootersResponse {
        val res = runSimulation(
                request.fleetManagerCapacity,
                request.fleetEngineerCapacity,
                request.scooters.toIntArray())
        return ScootersResponse(res)
    }
}
