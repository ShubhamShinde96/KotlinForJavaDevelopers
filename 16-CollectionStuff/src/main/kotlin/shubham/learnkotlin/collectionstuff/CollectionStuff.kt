package shubham.learnkotlin.collectionstuff

fun main() {

    val setInts = setOf(10, 15, 19, 5, 3, -22)


    println(setInts.filter { it % 2 != 0 })

    val immutableMap = mapOf<Int, Car>(1 to Car("Green", "Toyota", 2015),
        2 to Car("Red", "Ford", 2016),
        3 to Car("Silver", "Honda", 2013),
        17 to Car("Red", "BMW", 2015),
        8 to Car("Green", "Ford", 2010))

    println(immutableMap.toSortedMap()) // will sort by key

    println(immutableMap.filter { it.value.year == 2016 })

    println(immutableMap.map { it.value.year })
    println("-----------------")
    println(immutableMap.filter { it.value.model == "Ford" }
        .map { it.value.color }) // Here we're getting color property of objects who pass through the filter.
    println("-----------------")

    println(immutableMap.all { it.value.year >= 2015 }) // "all" checks the condition for all elements & even if 1 does not matches it will return false
    println(immutableMap.any { it.value.year >= 2015 }) // "any" will return true if at-least one condition matches.
    println(immutableMap.count { it.value.year >= 2015 })

    val cars = immutableMap.values
    println(cars.find { it.year >= 2015 }) // this will return first item that satisfies the condition

    println("****************************")
    println(cars.groupBy { it.color })
    println(cars.sortedBy { it.year })
    println("****************************")

    val mutableMap = mutableMapOf<Int, Car>(1 to Car("Green", "Toyota", 2015),
        2 to Car("Red", "Ford", 2016),
        3 to Car("Silver", "Honda", 2013))

    mutableMap.filter { it.value.color == "Silver" } // Filter function returns filtered result of map, it doesn't change/filter the actual map, if you print the actual map later then it's going to be same(unfiltered)


    println("The filtered map is ${mutableMap}")

    val ints = arrayOf(1, 2, 3, 4, 5)
    val add10List: MutableList<Int> = mutableListOf()

    for(i in ints) {
        add10List.add(i + 10)
    }

    println(add10List)

    val addTenList = ints.map { it + 10 }
    println(addTenList)

}

data class Car(val color: String, val model: String, val year: Int) {



}









































































