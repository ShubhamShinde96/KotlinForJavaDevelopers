package academy.learnprogramming.oochallenge

fun main() {

    val kotlinBicycle = KotlinBicycle(4, 10, 6)
    kotlinBicycle.printDescription()

    val kotlinMountainBike = KotlinMountainBike(3, 4, 5, 8)
    kotlinMountainBike.printDescription()

    val kotlinRoadBike = KotlinRoadBike(5, 3, 4, 6)
    kotlinRoadBike.printDescription()

    val kotlinBicycle2 = KotlinBicycle(4, 10)
    kotlinBicycle2.printDescription()

    val kotlinMountainBike2 = KotlinMountainBike(seatHeight = 3, cadence = 4, speed =  8)
    kotlinMountainBike2.printDescription()

    val kotlinRoadBike2 = KotlinRoadBike(tireWidth = 5, cadence = 3, speed = 6)
    kotlinRoadBike2.printDescription()

//    val kotlinMountainBike3 = KotlinMountainBike(seatHeight = 3, cadence = 4, speed =  8, color = "#sdffsd")
    val kotlinMountainBike3 = KotlinMountainBike(3, 4, speed =  8, color = "#sdffsd")
    kotlinMountainBike3.printDescription()

    println("List elements: ${KotlinMountainBike.MyCompObject.availableColors.toString()}")

    KotlinMountainBike.MyCompObject.availableColors.forEach {
        println("Color: $it")
    }


}




