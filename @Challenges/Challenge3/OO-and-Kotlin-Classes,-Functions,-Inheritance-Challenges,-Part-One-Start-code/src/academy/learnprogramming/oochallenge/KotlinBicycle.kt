package academy.learnprogramming.oochallenge

open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    // no need to make these properties final, as outside world always need to go through gets and sets method to access
    // the properties of data class in kotlin

    fun applyBreak(decrement: Int) {
        speed -= decrement;
    }

    fun speedUp(increment: Int) {
        speed += increment;
    }

    open fun printDescription() {

        println("Bike is in gear $gear with a cadence of $cadence" +
                " travelling at a speed of $speed.")

    }

}
