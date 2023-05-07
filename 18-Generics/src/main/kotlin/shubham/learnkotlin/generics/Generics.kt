package shubham.learnkotlin.generics

import java.math.BigDecimal

fun main() {

    val list: MutableList<String> = mutableListOf("Hello") // It's compulsory in kotlin to provide "Generic Type" while creating any type of collection - unlike java
    val list1 = mutableListOf("Hello") // or you can infer itm after adding a value it will consider its type

    list1[0].uppercase()

    list1.add("Another String")

    printCollection(list1)


    val bdList = mutableListOf(BigDecimal(-33.45), BigDecimal(3503.99),
                    BigDecimal(0.329)
    )

    printCollection(bdList)

    bdList.printCollectionExt()  // calling extension function

}


// We have to use <T> at both side like this to indicate that the function is using "Generics".
// This <T> after "fun" is called "type parameter declaration.
// Basically we are saying this function can accept any type of list
fun <T> printCollection(collection: List<T>) {

    for (item in collection) {

        println(item)
    }
}

// defining the function "Extension function" that can be invoked with a collection of type <T>.
fun <T> List<T>.printCollectionExt() {

    for (item in this) { // now as this is an extension function with generics, we're referring to "list" using "this".

        println(item)
    }
}

// here <T> is nullable <T: Any?> basically nullable, you can make it not nullable, just define like <T: Any> explicitly

// Now in addition to having a generic type as a function parameter, you can also use generics as a functions return type
// the specific type that returned can be inferred by the compiler.
// Like java we can also declare generic classes and interfaces in kotlin.