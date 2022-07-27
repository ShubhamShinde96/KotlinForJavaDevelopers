package academy.learnprogramming.oochallenge

class KotlinMountainBike(var seatHeight: Int, cadence: Int, gear: Int = 10, speed: Int): KotlinBicycle(cadence, speed, gear) {

//    var color: String = ""

    constructor(seatHeight: Int, cadence: Int, gear: Int = 10, speed: Int, color: String) : this(seatHeight, cadence, gear, speed) {

        println("This is the color: $color")
//        this.color = color
    }

    override fun printDescription() {
        super.printDescription()

        println("The mountain bike has a seat height of: $seatHeight inches.")
    }

//    var myCompObj = MyCompObject

    companion object MyCompObject {

        val availableColors = listOf("blue", "red", "white", "black", "green", "brown")

    }

}
