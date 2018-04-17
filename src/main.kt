fun main(args : Array<String>) {

//    if (args.isEmpty()) {
//        println("Please provide a name as a command-line argument")
//        return
//    }



    val fleetManagerCapacity = 9
    val fleetEngineerCapacity = 5
    val scooters = scootersOf(11, 15, 13)

    //run all simulations, get the best one
    val res = scooters.runSimulation(fleetManagerCapacity,fleetEngineerCapacity)

    println(res)
}




