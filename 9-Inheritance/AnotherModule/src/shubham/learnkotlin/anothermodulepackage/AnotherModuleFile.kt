package shubham.learnkotlin.anothermodulepackage

import shubham.learnkotlin.inheritance.CompanyCommunications
import shubham.learnkotlin.inheritance.topLevel

fun main() {

    topLevel("Hello from another module")

    // Remember you can only import top-level functions like this, you can't use functions which are inside some class like this
    // You have to import and instantiate class in order to call or use functions which are inside that class.

    // Extension functions are top level functions, you can import them the same way, just by name.
//    CompanyCommunications.getCopyrightLine()


}