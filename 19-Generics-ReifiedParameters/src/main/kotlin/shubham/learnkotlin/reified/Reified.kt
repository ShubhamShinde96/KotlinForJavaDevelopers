package shubham.learnkotlin.reified

import java.math.BigDecimal

fun main() {

    // Reification is a kotlin feature that prevents the type from being erased at runtime.

    val mixedList: List<Any> = listOf("String", 1, BigDecimal(22.5), "Shubham", 12.3f, BigDecimal(-5938.393849))

    val bigDecimal = getElementOfType<String>(mixedList) // Change its type to String, Float, or BigDecimal to see the result.
                    // here while calling this function we have to tell the compiler what type we want back.

    for(item in bigDecimal) {
        println(item)
    }

}

// The only reason you want to use reification is if you want to check the type of T withing the function.
// If you want to use reified type parameter then you have to inline the function.
inline fun <reified T> getElementOfType(list: List<Any>): List<T> {

    var newList: MutableList<T> = mutableListOf()

    for (element in list) {
        if(element is T){ // Error: cannot check for instance of erased type T.

            // We have to reify the function and make it inline in order to get rid of this error
            newList.add(element)
        }
    }

    return newList
}