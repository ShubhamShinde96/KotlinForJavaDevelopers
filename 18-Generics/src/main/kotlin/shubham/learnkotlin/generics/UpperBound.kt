package shubham.learnkotlin.generics

import java.lang.Appendable
import kotlin.text.StringBuilder

fun main() {

    val ints = listOf(1, 2, 3, 4, 5)
    val shorts: List<Short?> = listOf(10, 20, 30, 40) // we're explicitly telling compiler that we want the list of "Shorts" otherwise the compiler will assume them as an Int
    val floats: List<Float?> = listOf(100.3f, -459.43f) // we're explicitly telling compiler that we want the list of "Floats" otherwise the compiler will assume them as a Double
    val strings = listOf("1", "2", "3")

    convertToInt(ints)
    convertToInt(shorts)
    convertToInt(floats)
//    convertToInt(strings)

    append(StringBuilder("String 1"), StringBuilder("String 2"))


    if(strings is List<String>) { // This is how you have to check.
        println("This list contains string.")
    }

    var listAny: Any = listOf("str1", "str2")

//    if(listAny is List<String>) { // This will show error, as list is type of any, you can't even check like if(listAny is List)
    if(listAny is List<*>) { // This is star projection syntax
        println("This is a list, thank you star projection.")
    }

    listAny = listOf(1, 2, 3, 4, 5)

    if(listAny is List<*>) {
        println("This list contains strings")
        val strList = listAny as List<String>
        println(strList[1].replace("str", "string"))
    }

//    printsCollection(shorts)
    printsCollection(strings)

    // Behind the scene "Generic Types" erased at runtime by JVM, what this means is JVM treats List<String> as a just List, it does not have idea that List is a type of string.
    // JVM only knows checks "Generic things" at compile time.

}
    // We're specified the "Upper Bound" here: Accepting any type of numbers list.
fun <T: Number?> convertToInt(collection: List<T>){
    // but before we changed to <T: Number>, what was the upperbound? : the upper bound was nullable Any (Any?)

    for (num in collection) {

        println("${num?.toInt()}") // toInt() is showing error because there is no guarantee that received list is of numbers
        // So in this case what we'll do is we will say that we only want to accept list of "Numbers".
        // So basically like int short are subclasses of class "Number"

    }
}


// By default <T> is <T: Any?>  here Any is nullable, so if you want to accept non-nullable values of type Any then make it like <T: Any>
fun <T: Any> printsCollection(collection: List<T>) {

    for (item in collection) {

        println(item)
    }
}

    // If you want more than one upperbound, in that case you can use where clause
fun <T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable { // Here we have 2 upperbounds, we need charsequence here because appendable interf

        // You can have multiple interfaces in the where clause, but obviously you can only have one class in the interface.
        println("Result is ${item1.append(item2)}")
    }














