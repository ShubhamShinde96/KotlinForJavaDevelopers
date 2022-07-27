package shubham.learnkotlin.loops

fun main() {

    val range = 1..5

    for(i in range) {
        println(i)
    }

    val charRange = 'a'..'z'

    val stringRange = "ABC".."XYZ"

    println(3 in range)
    println('q' in charRange)
    println("CCC" in stringRange)
    println("CCCCCC" in stringRange)
    println("ZZZZZZ" in stringRange)

    val backwardRange = 5.downTo(1)
//    val r = 5..1
    println(5 in backwardRange)

    val stepRange = 3..15
    val stepThree = stepRange.step(3)
    val reversedRange = range.reversed()


    for(i in stepRange) {
        println(i)
    }

    for(r in reversedRange) {
        println(r)
    }

    val str = "hello"
    for(c in str) {
        println(c)
    }

    for(num in 1..20 step 4) {
        println(num)
    }

    println("***********************")

    for(i in 20 downTo 10 step 5) {
        println(i)
    }

    println("* * * * * * * * UNTIL * * * * * * * * * *")
    for(i in 1 until 10) {
        println(i) // 10 will be excluded in "until"
    }

    val s = "GoodBye"
    val sRange = 1..s.length


    val seasons = arrayOf("Spring", "Summer", "Winter", "Fall")
    val seasons2 = mutableListOf<String>("Spring", "Summer", "Winter", "Fall")
    seasons2.add("")

    val arr = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 9)
    arr.sort()



    for(season in seasons) {
        println(season)
    }

    val notASeason = "Monsoon" !in seasons
    println("notASeason: $notASeason")

    val notInRange = 32
    println(notInRange !in 1..10)

    val strs = "Hello"
    println('e' !in strs)

    for(index in seasons.indices) {
        println("${seasons[index]} is season number: $index")
    }

    for((index, element) in seasons.withIndex()) {
        println("${index}th element is: $element")
    }

    seasons.forEach {
        println(it)
    }

    seasons.forEachIndexed { index, s ->

        println("$s is season number: $index")
    }



    for(i in 1..3) {

        println("i = $i")

        jloop@ for(j in 1..4) {

            println("j = $j")

            for(k in 5..10) {

                println("k = $k")
                if(k == 7){
                    break@jloop
//                    continue@jloop
                }
            }
        }
    }









}