package shubham.learnkotlin.inheritance

import java.time.Year

fun main() {

    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())

    println(SomeClass.SomeCompanion.accessPrivateVar())

    val someClass1 = SomeClass.SomeCompanion.justAssign("this is the string as is")
    val someClass2 = SomeClass.upperOrLowercase("this isn't the string as is", false)

    println(someClass1.someString)
    println(someClass2.someString)


    var thisIsMutable = 45
    // So we're going to create an anonymous instance using object keyword
    wantsSomeInterface(object: SomeInterface{
        override fun MustImplement(num: Int): String {

            thisIsMutable++
            return "This is from mustImplement: ${num * 100}"
        }
    }) // you can use multiple interface as parameter like this

    println("thisIsMutable: $thisIsMutable")


    println(Department.ACCOUNTING.getDepartmentInfo())

}

// singleton in kotlin
// There is a special keyword object for singletons in Kotlin.
// You can just type something as simple as this to get working singleton class:

//In object-oriented programming, a singleton class is a class that can have only one object (an instance of the class) at a time.
// After first time, if we try to instantiate the Singleton class, the new variable also points to the first instance
// created. So whatever modifications we do to any variable inside the class through any instance,
// it affects the variable of the single instance created and is visible if we access that variable through any variable
// of that class type defined.


// FOR JAVA
//Make constructor private.
//Write a static method that has return type object of this singleton class. Here, the concept of Lazy initialization
// is used to write this static method.

// in kotlin there's a way to define a class & define an instance at the same time & this is where "object" keyword comes
// in, there are 3 use cases of "object" keyword
// 1] Singleton,  2] Companion Object,   3] Object Expression

// Singleton : is used when we want only one instance of a class is running, if we try to create a new instance then
// it will point to the previous instance that was created before (basically it will only keep one instance)
// In java we declare a class with a private constructor and then the outside world get access to a single instance that
// the class creates, and we can access to that instance using a static method
 // But when you want singleton in kotlin we'll use "object" keyword because there could be only one instance of "object" class.

// Use-case: for ex a company wants a same copyright message, the same tagline etc. for all of its communication
// To create this file we did like: Right click on package name > New > Kotlin class/file > select type as object, type filename and press okay.
object CompanyCommunications { // This is singleton object (Singleton class)
    // so this is basically an object class & you'll see there is no "class" keyword here, there's just "object" keyword.
    // other code in this file is created later, we've this object class created first
    // Now such object classes can't have constructors because the "object" declaration get declared and creates an instance
    // at the same time so having constructor wouldn't make sense

    // object declarations (Singleton classes) can extend another classes and interfaces if you want.

    val currentYear = Year.now().value


    fun getTagLine() = "Our company rocks!"
    internal fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
    // internal restrict access from another module, although it allows to use the property from the same module it is currently in,
    // doesn't matter how many packages you have in that module, property is accessible from any file within the same module.

}


class SomeClass private constructor(val someString: String) {

//    val someString: String

    /*constructor(str: String) {

        someString = str
    }

    constructor(str: String, lowerCase: Boolean) {

        if(lowerCase) {
            someString = str.lowercase()
        } else {

            someString = str.uppercase()
        }
    }*/

    // Factory method - if you want to construct current class then you have to get instance of this class
    // This is how you can create private primary constructor & you can prevent accessing the primary constructor
    // and it has to go through one of the methods of companion object.

    //    companion object {
//    companion objects are singleton objects whose properties and functions are tied to a
//    class but not to the instance of that class — basically like the “static” keyword in Java but with a twist.
//    in kotlin we can use top level functions, properties & object declarations like companion object when it makes sense.
//    Remember! We don't need to create an instance to access static properties, we just refere to classname and "." and
//    call(name) the property or method which is static  For ex: SomeClass.staticVariableName

    // So to make anything "static" in kotlin you have to put it under "companion object block"

//    companion object {
    companion object SomeCompanion { // You can give names like this to companion object.

        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        fun justAssign(str: String) = SomeClass(str) // This is called expression body
    // So you'll have to call this justAssign() in order to construct the constructor of the class
    // so this way will prevent others to directly make an instance of this class, by doing this maybe you can write
    // certain conditions in this justAssign() method before constructing the instance.

        fun upperOrLowercase(str: String, lowerCase: Boolean): SomeClass {

            // This is called a block body

            if (lowerCase) {
                return SomeClass(str.lowercase())
            } else {

                return SomeClass(str.uppercase())
            }
        }

    }

    /*private val privateVar = 6

    fun accessPrivateVar() {
        println("I'm accessing privateVar: $privateVar");
    }*/

}



// Anonymous objects
interface SomeInterface {

    fun MustImplement(num: Int): String

}

fun wantsSomeInterface(si: SomeInterface) {

    println("Printing from wantsSomeInterface ${si.MustImplement(22)}")
}


enum class Department(val fullName: String, val numEmployees: Int) {

    HR("Human Resources", 5), IT("Information Technology", 10),
    ACCOUNTING("Accounting", 3), SALES("Sales", 20);

    // When you add function in enum you have to add semicolon for ending enums

    fun getDepartmentInfo() = "The $fullName department has $numEmployees employees"
}

    fun topLevel(str: String) = println("Top level function: $str")

fun String.upperFirstAndLast(): String {

    val upperFirst = substring(0, 1).uppercase() + substring(1) // here you can also remove this substitution like that.

    println("upperFirst: ${upperFirst.substring(0, upperFirst.length - 1)}")

    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).uppercase()
}



































































