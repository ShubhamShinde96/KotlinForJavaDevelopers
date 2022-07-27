package academy.learnprogramming.oochallenge

class KotlinRoadBike(val tireWidth: Int, cadence: Int, gear: Int = 10, speed: Int): KotlinBicycle(cadence, speed, gear) {


    override fun printDescription() {
        super.printDescription()

        println("The road bike has a seat height of: $tireWidth MM.")
    }

}