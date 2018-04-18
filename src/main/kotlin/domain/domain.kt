package domain

// Domain model
//
// The task contains no requirements on performance nor memory footprint, the requirements also states low numbers for size and ranges.
// Thus, choosing a solution with low development, maintenance and cognitive cost is favorable
//
// This solution runs in O(n) time
fun runSimulation(fleetManagerCapacity: Int, fleetEngineerCapacity: Int, scooters: IntArray): Int {
    when {
        fleetManagerCapacity !in 1..999 -> throw IllegalArgumentException("fleetManagerCapacity must be between 1 and 999")
        fleetEngineerCapacity !in 1..1000 -> throw IllegalArgumentException("fleetEngineerCapacity must be between 1 and 1000")
        scooters.count() !in 1..100 -> throw IllegalArgumentException("scooters count must be between 1 and 100")
        scooters.any { it !in 0..1000 } -> throw IllegalArgumentException("scooters elements must be between 0 and 1000")
        else -> {

            val requiredFleetEngineers = { scooters: Int -> Math.ceil(scooters.toDouble() / fleetEngineerCapacity).toInt() }

            // step 1, first scan calculates the needed FEs per district 1. if the FM is not there, 2. if the FM is there.
            // so we have a list of pairs with the two values per district
            val precalculated = scooters.map {
                Pair(requiredFleetEngineers(it), requiredFleetEngineers(it - fleetManagerCapacity))
            }

            // step 2, caclulates a speculative total. this is the sum of the required engineers without taking the FM into account
            val speculativeSum = precalculated.sumBy { it.first }

            // the final step 3, then folds over the precalculated just and evaluates the required engineers if the manager is in this district.
            return precalculated.fold(Int.MAX_VALUE, { acc, pair -> Math.min(acc, speculativeSum - (pair.first - pair.second)) })
        }
    }
}
