package shubham.learnkotlin.loops

import java.math.BigDecimal

enum class Season {

    SPRING, SUMMER, FALL, WINTER

}

fun main() {

    val num = 240

    when(num) {

        100, 600 -> println("600")
        in 200..299 -> println("in range 200..299")
        300 -> println("300")
        400 -> println("400")
        500 -> println("500")
        else -> println("Out of range.")

    }


    val y = 10

    when(num) {

        y + 230 -> println("320")
        y + 90 -> println("330")
        else -> println("Not a valid case.")

    }


    val obj: Any = "I'm a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

    val something: Any = obj2

   /* if(something is String) {

        println(something.uppercase())

    } else if(something is BigDecimal){

        println(something.remainder(BigDecimal(10.5)))

    } else if(something is Int) {

        println(something - 22)

    }*/

    val z = when(something) {

        is String -> {
            println(something.uppercase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            2
        }
        is Int -> {
            println(something - 22)
            3
        }
        else -> {
            println("Sorry, unrecognised type!")
            -1
        }
    }

    println("z = $z")

    val timeOfYear = Season.WINTER
    var numT = 100

    val str = when(timeOfYear) {

        Season.SPRING -> {
            numT += 5
            "Flowers are blooming."
        }
        Season.SUMMER -> {
            numT += 10
            "It's hot!"
        }
        Season.FALL -> {
            numT += 15
            "It's getting cooler."
        }
        Season.WINTER -> {
            numT += 20
            "It's very cold, I need a coat."
        }
    }

    println(str)

    val num2 = -50

    if(num < num2) {

        println("num is less than num2")

    } else if(num > num2) {

        println("num is greater than num2")

    } else {

        println("num == num2")
    }


    when {
        num < num2 -> println("num is less than num2")
        num > num2 -> println("num is greater than num2")
        else -> println("num == num2")
    }



}







































