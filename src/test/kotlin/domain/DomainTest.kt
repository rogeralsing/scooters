package domain
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DomainTest {

    //[]scooters will contain between 1 and 100 elements.
    //Each element in scooters will be between 0 and 1000.
    @Test fun `scootersOf yields scooters of given valid entries`() {
        val scooters = scootersOf(1,2,500)
        assertEquals(3, scooters.count())
    }

    /*
    1)
    input:
    { scooters: [15, 10],
    C: 12,
    P:5 }
    expected output:
    { fleet_engineers: 3 }
     */
    @Test fun `runSimulation yields correct result given args of testcase 1`() {
        val scooters = scootersOf(15,10)
        val res = runSimulation(12,5,scooters)
        assertEquals(3,res)
    }

    /*
    2)
    input:
    { scooters: [11, 15, 13],
    C: 9,
    P:5 }
    expected output:
    { fleet_engineers: 7 }
     */
    @Test fun `runSimulation yields correct result given args of testcase 2`() {
        val scooters = scootersOf(11,15,13)
        val res = runSimulation(9,5,scooters)
        assertEquals(7,res)
    }


    //[]scooters will contain between 1 and 100 elements.
    @Test fun `scootersOf fails given no entries`() {
        assertFailsWith<IllegalArgumentException> {
            scootersOf()
        }
    }

    //Each element in scooters will be between 0 and 1000.
    @Test fun `scootersOf fails given negative entries`() {
        assertFailsWith<IllegalArgumentException> {
            scootersOf(0,0,0,-1)
        }
    }

    //Each element in scooters will be between 0 and 1000.
    @Test fun `scootersOf fails given greater than 1000 entries`() {
        assertFailsWith<IllegalArgumentException> {
            scootersOf(1,2,3,1001)
        }
    }
}
