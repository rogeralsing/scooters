package testtask.scooters
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ScooterServiceTest {

    /*
    1)
    input:
    { scooters: [15, 10],
    fleetManagerCapacity: 12,
    fleetEngineerCapacity:5 }
    expected output:
    { fleetEngineers: 3 }
     */
    @Test fun `runSimulation yields correct result given args of testcase 1`() {
        val res = runSimulation(12, 5, intArrayOf(15, 10))
        assertEquals(3,res)
    }

    /*
    2)
    input:
    { scooters: [11, 15, 13],
    fleetManagerCapacity: 9,
    fleetEngineerCapacity:5 }
    expected output:
    { fleetEngineers: 7 }
     */
    @Test fun `runSimulation yields correct result given args of testcase 2`() {
        val res = runSimulation(9, 5, intArrayOf(11, 15, 13))
        assertEquals(7,res)
    }


    //[]scooters will contain between 1 and 100 elements.
    @Test fun `runSimulation fails given no scooter entries`() {
        assertFailsWith<IllegalArgumentException> {
            runSimulation(9, 5, intArrayOf())
        }
    }

    //Each element in scooters will be between 0 and 1000.
    @Test fun `runSimulation fails given negative scooter entries`() {
        assertFailsWith<IllegalArgumentException> {
            runSimulation(9, 5, intArrayOf(0, 0, 0, -1))
        }
    }

    //Each element in scooters will be between 0 and 1000.
    @Test fun `runSimulation fails given greater than 1000 scooter entries`() {
        assertFailsWith<IllegalArgumentException> {
            runSimulation(9, 5, intArrayOf(0, 0, 0, 1001))
        }
    }
}
