package shubham.learnkotlin.lambdas

fun main() {

    val strings = listOf("Spring", "Summer", "Fall", "Winter")
    println(strings.javaClass)

    val emptyList: List<String> = emptyList<String>()
    println(emptyList.javaClass)

    if(!emptyList.isEmpty()) {
        println(emptyList[0])
    }

    val notNullList = listOfNotNull("Hello", null, "GoodBye")
    println(notNullList) // in this list null will not be added, this is how notNull list serves you

    // So is there any way of using java.util.ArrayList in kotlin, yes following is the way
    val arrayList = arrayListOf(1, 2, 4)
    println(arrayList.javaClass)

    val mutableList = mutableListOf(1, 2, 3)
    println(mutableList.javaClass)

    println(mutableList[2])
    mutableList[1] = 20
    println(mutableList)
    mutableList.set(2, 30)
    println(mutableList.get(2))

    val array = arrayOf("Black", "White", "Green")
    val colorList = listOf(*array) // remember * is the spread operator in kotlin
    val colorList2 = array.toList() // this is more easier way
    println(colorList)
    println(colorList2)

    val ints = intArrayOf(1, 2, 3, 4)
    println(ints.toList())

}














































