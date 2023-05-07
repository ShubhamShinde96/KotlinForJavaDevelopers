package shubham.learnkotlin.reified

import java.math.BigDecimal

fun main() {

    // Reification is a kotlin feature that prevents the type from being erased at runtime.

    val mixedList: List<Any> = listOf("String", 1, BigDecimal(22.5), "Shubham", 12.3f, BigDecimal(-5938.393849))

    val bigDecimal = getElementOfType<String>(mixedList) // here as we have passed generic return type of function as a
    // string that's why we are only getting the list which contains the string objects and it will exclude the object with
    // types other than string.
    // Change its type to String, Float, or BigDecimal to see the result.
    // so that's why here while calling this function we have to tell the compiler what type (generic type) of list we want back
    // from this function.


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

            // back when we made a function "inline" when the function had lambda function as a parameter
            // but now the another scenario for making a function inline is when we have a generic type as a parameter, because
            // inline function parameters can be whats called reified, now reification is a kotlin feature that prevents the
            // type from being erased at runtime. If you declare a function as inline and type parameter as reified then you
            // can check the generic type at runtime.
            // We have to reify the function and make it inline in order to get rid of this error and now that we've done that
            // we don't have the error here anymore.
            newList.add(element)
        }
    }

    return newList
}


// IMP: now it shows how by reifying the type T parameter we can get the generic type inside the function and the type isn't
// erased at runtime.
// Actually it's like we are saying the function can accept anything but what as we are passing the type explicitly while
// calling it so we can use that type and then maybe decide what to do with it and return only values with passed type.

// So you want to do this thing when you need to check the type within a function otherwise there absolutely no reason to use
// reification, so we only want to use reification when we want to check the type inside the function.

/// Now you can't mark classes, properties or non-inlined functions as reified.
// like for ex: "class Something<reified T>" you can't do this.

// Also you can't create new instances of type T, like below
// val c: T = T()    // no, you can't do this within the function or off-course outside the function too
// there are some other restrictions as well but there are alot so you'll get compiler will always tell you
// when you're doing something that can't be done, pretty clear.











