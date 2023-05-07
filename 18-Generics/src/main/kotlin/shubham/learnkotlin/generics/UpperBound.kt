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

    // So see here we're passing list of int, short and floats to the same function to the same expected parameter

//    convertToInt(strings) // here we'll get error cause it does not satisfy the upperbound as string is not a subclass of class Number
    // so what if we want a function with more than one upperbound? in that case we'll have to use "where" clause. see below written append()
    // function for more than one upperbound

    append(StringBuilder("String 1"), StringBuilder("String 2"))


    if(strings is List<String>) { // See we're not getting an error here in kotlin, if you run then it runs and prints the result correctly.
        // so how can JVM compiler is checking for generic type <String> at runtime?
        // so actually under the cover this "if" is isn't even generated to the bytecode. because the compiler can see that it is always going
        // to evaluate to true, so there's no need to do this check at runtime, kotlin can figure it out at compile time and adjust the bytecode
        // accordingly.
        println("This list contains string.")
    }

    var listAny: Any = listOf("str1", "str2")

//    if(listAny is List<String>) { // This will show error, as list is type of any, you can't even check like if(listAny is List)
    // so here kotlin can no longer guaranty about this as it cannot even check this at compile time & that's why we're getting the error.
    // but why we can't check "listAny is List" as we can do the same in java, because "in kotlin you have to specify the generic type as it's
    // enforced in kotlin". So how can we check if it's a list, the answer is below.
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

        println("${num?.toInt()}") // toInt() is showing error because there is no guarantee that the received list is of numbers so that it
        // can perform toInt safely, for boolean obviously it will get some kinda type conversion error.
        // So in this case what we'll do is we will say that we only want to accept list of "Numbers".
        // So basically int, short, double and all other number types are subclasses of class "Number", so if we specify that we are expecting
        // a number type of parameter then this way the function will accept a list of number or it will accept a list of instances that are
        // subclasses of number and if they are subclasses of number then they gonna have this toInt() function.
        // in this way it will not show error.

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
    where T: CharSequence, T: Appendable { // Here we have 2 upperbounds, we need CharSequence here because appendable interface
        // here we need CharSequence because the Appendable interface work with CharSequences.

        // now here as CharSequence is a class and Appendable is an interface, you can have more than one interfaces in the where clause but
        // you can only have only one class in the where clause, because if more than one class allowed in where clause then nothing will
        // ever satisfy your where clause. so that's why we can't do like  "where T: Short, T: Int" cause both Short and Int are classes.

        // You can have multiple interfaces in the where clause, but obviously you can only have one class in the interface.
        println("Result is ${item1.append(item2)}")
    }


// When a java application runs it doesn't have any of the generic information and that's called "Type Erasure", so that information is erased
// so at compile time we might declare an array list of BigDecimal but at runtime all the JVM will see is array list, it doesn't see the
// generic type, so generics are basically syntactical elements that help "us" and "compiler".
// Now because the generics don't make it through to the application that the JVM runs, you can't use them to do type-checking.











