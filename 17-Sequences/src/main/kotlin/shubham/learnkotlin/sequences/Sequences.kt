package shubham.learnkotlin.sequences

fun main() {


    val immutableMap = mapOf<Int, Car>(1 to Car("Green", "Toyota", 2015),
        2 to Car("Red", "Ford", 2016),
        3 to Car("Silver", "Honda", 2013),
        17 to Car("Red", "BMW", 2015),
        8 to Car("Green", "Ford", 2010))

    println(immutableMap.filter { it.value.model == "Ford" }
        .map { it.value.color })  // here this works fine, but what if we have collection of thousands of items
    // we have to avoid performing more operation on intermediate collections, like we are doing in above example.
    // we have to use sequences for that. You can avoid intermediate collections using sequences.

    // Another use-case of sequences is if you don't know how many items you're gonna fill in, depends on your API call, here sequence will work.

    println(immutableMap.asSequence().filter { it.value.model == "Ford" }
        .map { it.value.color }) // Now second condition will be checked if first condition is satisfied in this case of sequences. This is the difference between sequences and map


    listOf("Joe", "Marry", "Jane").asSequence()
        .filter { println("Filtering $it"); it[0] == 'J' }   // This is another use of semicolon in kotlin
        .map { println("Mapping $it"); it.uppercase() }
        .find { it.endsWith("E") } // capital "E" because we've uppercased it
//        .toList() // .toList() is a terminal operation in sequence
    // This is similar to streams in java.

    // Sequences are lazily evaluated, so they're not evaluated until the terminal operation has performed.



}

data class Car(val color: String, val model: String, val year: Int) {


}



































