package shubham.learnkotlin.challenge4

fun main(array: Array<String>) {

    for (i in 5..5000 step 5) {
//        println("i: $i")
    }

//    println("Printing 500 to 1, basically printing inclusively")
    for (i in 500.downTo(1)) {

//        println("i: $i")
    }

    for (i in -500..0) {

//        println("i: $i")
    }

    // Challenge: To print the fibonacci series using range

    var add = 0
    var oldVal = 0
    var newVal = 1

    for(i in 0..14) {


        add = oldVal + newVal
        oldVal = newVal
        newVal = add


//        println(add)
    }


    // 1, 11, 100, 99, 98, 2

    /*iLoop@ for (i in 1..5) {
        println(i)
        jLoop@ for (j in 11..20) {

            if(i == 2) {
                break@iLoop
            } else if(j > 11){
                continue
            }
            println(j)
            for (k in 100.downTo(90)) {

                println(k)
                if(k == 98) {
                    break
                }

            }
        }

    }*/

    // instructor solution

    iLoop@ for (i in 1..5) {
        println(i)
        if(i == 2) {
            break
        }
        jLoop@ for (j in 11..20) {
            println(j)
            for (k in 100.downTo(90)) {

                println(k)
                if(k == 98) {
                    continue@iLoop
                }

            }
        }

    }


    // Next challenge
    var num = 102

    var dnum: Double = if(num > 100) -234.567 else if(num < 100) 4444.555 else 0.0
    println("dnum: $dnum")

    when {

        num > 100 -> dnum = 234.567
        num < 100 -> dnum = 4444.555
        else -> dnum = 0.0
    }


}