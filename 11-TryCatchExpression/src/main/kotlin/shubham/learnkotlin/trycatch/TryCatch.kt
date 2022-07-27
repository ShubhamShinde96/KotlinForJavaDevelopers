package shubham.learnkotlin.trycatch

import java.lang.NumberFormatException

fun main() {

//    println(getNumber("22.5") ?: throw IllegalArgumentException("Number isn't an Int"))
//    println(getNumber("22.5") ?: "I can't print the results!")

    notImplementedYet("Yeyy")

}

                            // If you're sure about function is not going to return anything then you can set its return type to "Nothing"
fun notImplementedYet(something: String): Nothing {

    throw IllegalArgumentException("Implement me!")
}

fun getNumber(str: String): Int? {

    return try {
        Integer.parseInt(str)
    }
    catch (e: NumberFormatException) {
//        0
        null
    }
    finally {
        println("I'm in the finally block.")
        1
        // you can execute code in the finally block but no value can be returned from the finally block
    }

}