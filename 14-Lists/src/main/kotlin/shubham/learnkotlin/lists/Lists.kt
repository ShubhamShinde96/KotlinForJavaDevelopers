package shubham.learnkotlin.lists

fun main() {

    val strings = listOf("Spring", "Summer", "Fall", "Summer", "Winter", "Black")
    val colorList = listOf("Black", "White", "Red", "Black", "Red")

    val mutableSeasons = strings.toMutableList()
    mutableSeasons.add("Some other season")
    println(mutableSeasons)

    println(strings.last())
    println(strings.asReversed())

    if(strings.size > 5) {
        println(strings[5])
    }

    println(strings.getOrNull(5)) // This is a safe way instead of using if checks, but it will return(print in this case) "null" if index is out of bounds.

    val ints = listOf(1, 2, 24, 3, 4, 5)
    println(ints.maxOrNull())

    println(colorList.zip(strings))

    val mergedLists = listOf(colorList, strings)
    println(mergedLists)

    val combinedList = colorList + strings
    println(combinedList)

    val noDuplicatesList = colorList.union(strings) // avoid duplication - Union
    println(noDuplicatesList)

    val onlyCommonsList = colorList.intersect(strings) // filter common list - Union
    println(onlyCommonsList)

    val noDuplicatesColors = colorList.distinct() // Eliminating the duplicates without combining the lists
    println(noDuplicatesColors)


}