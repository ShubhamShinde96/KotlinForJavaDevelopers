package shubham.learnkotlin.covariance

fun main() {

    val shortsList: MutableList<Short> = mutableListOf(1, 2, 3, 4, 5)

//    convertToInt(shortsList) // 2] but as soon as we change to mutable list it is showing error that we expect mutable list of numbers here not mutable list of shorts

    // 3] This is happening because list is a class & not a type

}

fun convertToInt(collection: MutableList<Number>) { // 1] if we use list then its not giving error while calling this function with List<Short>

    for(num in collection) {
        println(num.toInt())
    }

    collection.add(25) // see!, here you are adding it int, if you use this function and pass list of short then there will be ambiguity created. cause here you're allowed to add any type of number, be it int, float, double
    // That's why there is restriction of covariant classes
}

fun waterGarden(garden: Garden<Flower>) {


}

fun tendGarden(roseGarden: Garden<Rose>) {

    waterGarden(roseGarden)
}

open class Flower {

}

class Rose: Flower() {

}

//class Garden<T: Flower> { // We are saying that the Garden is some type of Flower.
class Garden<out T: Flower>(private var something: T) { // Making the class covariant using "out" keyword
                    // remove private

    // This class is invariant

    val flowers: List<T> = listOf()

    fun pickFLower(i: Int): T = flowers[i]
//    fun plantFlower(flower: T) { // Uncomment this to see the error
        // Error: Type parameter T is declared as 'out' but occurs in 'in' position in type T
        // kotlin has notion of in and out positions
        // 'in' position is function parameter whereas 'out' position is return parameter

        // so error is because we are trying to use something as 'out' at 'in' position.
//    }
}