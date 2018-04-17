package backend

import domain.runSimulation
import domain.scootersOf
import org.springframework.web.bind.annotation.*

data class Request(val C:Int,val P:Int, val scooters: List<Int>)
data class Response(val fleet_engineers: Int)

@RestController
class ScooterController {
    @PostMapping("/scooters")
    fun greeting(@RequestBody request: Request) : Response {
        val scooters = scootersOf(*request.scooters.toIntArray())
        val res = runSimulation(request.C, request.P, scooters)
        return Response(res)
    }
}