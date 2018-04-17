//Domain model
typealias Scooters = Sequence<Int>

fun scootersOf(vararg scooters: Int): Scooters =
        when {
            scooters.count() !in 1..100 -> throw IllegalArgumentException("scooters count must be between 1 and 100")
            scooters.any { it !in 0..1000 } -> throw IllegalArgumentException("scooters elements must be between 0 and 1000")
            else -> scooters.asSequence()
        }

// The task contains no requirements on performance nor memory footprint, the requirements also states low numbers for size and ranges.
// Thus, choosing a solution with low development, maintenance and cognitive cost is favorable
fun Scooters.runSimulation(fleetManagerCapacity: Int, fleetEngineerCapacity: Int): Int? =
        when {
            fleetManagerCapacity !in 1..999 -> throw IllegalArgumentException("fleetManagerCapacity must be between 1 and 999")
            fleetEngineerCapacity !in 1..1000 -> throw IllegalArgumentException("fleetEngineerCapacity must be between 1 and 1000")
            //get the total number of engineers if the manager works in this district
            else -> this.mapIndexed { district, _ ->
                this
                        .withFleetManager(district, fleetManagerCapacity)
                        .toFleetEngineerCount(fleetEngineerCapacity)
            }.min() // the lowest number in all simulations is the correct answer
        }

fun Scooters.withFleetManager(fleetManagerDistrict: Int, fleetManagerCapacity: Int): Scooters =
        this.mapIndexed { district, scooters ->
            if (fleetManagerDistrict == district) scooters - fleetManagerCapacity //the FM is in this district, lower the remaining workload by the FMs capacity
            else scooters //the FM is not in this district, just forward value
        }

private fun Scooters.toFleetEngineerCount(fleetEngineerCapacity: Int) =
        this.map { scooters -> Math.ceil(scooters.toDouble() / fleetEngineerCapacity).toInt() }.sum()
