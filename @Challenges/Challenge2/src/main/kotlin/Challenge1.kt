fun main() {

    val numFlt = -3847.384f
    var numFlt2: Float? = 3847.384f
    numFlt2 = -3847.384f
    var float3: Float = 3847.384f.toFloat()

    // ----------------------------


    var shortArray1 = shortArrayOf(1, 2, 3, 4, 5)
    var shortArray2: Array<Short> = arrayOf(1, 2, 3, 4, 5)

    var nullableIntArray = Array<Int?>(40) {
        i -> (i + 1) * 5
    }

    for (i in nullableIntArray) {

        println("i: $i")
    }

    // -----------------------------------------------


    val charArray = charArrayOf('a', 'b', 'c')
//    DummyClass().printMethod(charArray)


    // -----------------------------------------------

    val x: String? = "I AM IN UPPERCASE"
    val y = x?.lowercase() ?: "I Give Up"
    println("y: $y")

    x?.let {
        println(it.lowercase().replace("am", "am not"))
    }


    val myNonNullVariable: Int? = null
    myNonNullVariable!!.toDouble()


}