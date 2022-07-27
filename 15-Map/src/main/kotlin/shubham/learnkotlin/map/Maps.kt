package shubham.learnkotlin.map

fun main() {

    val immutableMap = mapOf<Int, Car>(1 to Car("Green", "Toyota", 2015),
                                2 to Car("Red", "Ford", 2016),
                                3 to Car("Silver", "Honda", 2013))

    println(immutableMap.javaClass)
    println(immutableMap.toString())

    val mutableMap = hashMapOf<String, Car>("John's Car" to Car("Red", "Range Rover", 2010),
                                                "Jane's Car" to Car("Blue", "Hyundai", 2012))

    println(mutableMap.javaClass)
    println(mutableMap)

    mutableMap.put("Shubham's Car", Car("Black", "Jeep Compass", 2020))
                    // While putting we have to use comma "," for key value instead of "to" which we use while declaration

//    for(entry in mutableMap) {
    println("****************************")
    for((entry, value) in mutableMap) { // Destructuring here
        println(entry)
//        println(entry.key)
        println(value)
//        println(entry.value)
    }

    // How destructuring happens, you don't get that free, you have to implement Component Functions to do this.
    // Both the pair class and map class have implemented these Component Functions that's why we can destructure
    // its values

    val pair = Pair(10, "ten")
//    val firstValue = pair.first
//    val secondValue = pair.second
    val (firstValue, secondValue) = pair // This is destructuring declaration
    println(firstValue)
    println(secondValue)

    val car = Car("Blue", "Corvet", 2000)

    val (color, model, year) = car // you can do this if Car is a data class otherwise you have to implement Component Functions in Car class
    println("Color: $color, Model: $model, Year: $year")


    // **************** SETS ******************* //

    // Sets are similar to lists except they don't allow duplicate items

    val setInts = setOf(10, 15, 19, 5, 3, -22)
    println(setInts.plus(20)) // This is how you can add element to the set. **IMP this 20 value it added here only, it is not added in actual set, set is immutable you cannot add elements to it.
    println(setInts.plus(10)) // here 10 will not be added because 10 already exists in set, so it avoids duplicates
    println(setInts.minus(19))
    println(setInts.minus(100)) // Nothing happens, 100 does not exist
    println(setInts.average())
    println(setInts.drop(3))

    val mutableInts = mutableSetOf(1, 2, 3, 4, 5)
    mutableInts.plus(10)
    println(mutableInts) // plus just returns the result, it does not add element to original set even though its mutableSet
    // the same thing applies to minus(num)

}

class Car(val color: String, val model: String, val year: Int) {
//data class Car(val color: String, val model: String, val year: Int) {

    // Using Component Functions
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
    // This is how you can make your class destructurable. **
    // And offcourse the properties have to be public, if you have private properties then you can't participate in destructuring

    override fun toString(): String {
        return "{color: $color, model: $model, year:$year}"
    }
}