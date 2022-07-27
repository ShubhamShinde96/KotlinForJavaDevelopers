package shubham.learnkotlin.inheritance

fun main() {

    val laserPrinter = LaserPrinter("Brother 1234", 15)
    laserPrinter.printModel()

    SomethingElse("Whatever")

}

abstract class Printer(val modelName: String) { // abstract class is open by default to get extended

    // open because this function is not abstract
    open fun printModel() = println("The model name of this printer is $modelName")

    abstract fun bestSellingPrice() : Double  // just like class, an abstract function is "open" by default
    // we don't have to write "open" for abstract function to override it unlike normal function.
    // but "override" keyword is necessary

}

//class LaserPrinter : Printer() {
open class LaserPrinter(modelName: String, ppm: Int) : Printer(modelName) {

//    constructor(): super()

    // Making overridden function final like this will prevent it from overriding it again by next subclass
    // So you can make sure that only this version of this function will get executed when called & user will
    // not able to write his own definition to this particular function anymore
    final override fun printModel() = println("The model name of this laser printer is $modelName")

    override fun bestSellingPrice(): Double = 129.99

}

class SpecialLaserPrinter(modelName: String, ppm: Int) : LaserPrinter(modelName, ppm) {

//    override fun printModel() = println("This is my way of doing it.")
        // now we'll get an error here as we can't override this fun anymore as it is "final"


}


//open class Something(val x: Int) {
open class Something: MySubInterface {

//    var someProperty: String = "" // primary constructor always expected to initialize the properties
    var someProperty: String

    // Now a class contains concrete implementation of abstract property
    override val number: Int = 25
    override val number2: Int = 25

    constructor(someParameter: String ) {
        someProperty = someParameter
        println("I am in the parents constructor")
    }

    override fun MySubFunction(str: Int): String {

        return ""
    }

    override fun MyFunction(str: String): String {

        return ""
    }
}

class SomethingElse: Something {

//    constructor(someOtherParameter: String, z: Int): super(z) {
    constructor(someOtherParameter: String): super(someOtherParameter) {

    // we can only do this when we don't have the primary constructor in parent class because if parent class has primary
    // constructor then this constructor has to delegate to the primary constructor, so we can't delegate to the secondary
    // constructor here if we have primary constructor in parent class.

        println("I am in the child's constructor")
    }

}


data class DataClass(val number: Int) {

}
//  data classes are close tight, they can't be extended, they can't even be abstract or inner classes.
// data classes can extend other classes


interface MyInterface {

    val number: Int // now this is abstract as we haven't assigned the value to it.
    // so when you implement this interface in a class there you have to override this property and assign a value to
    // it there. (basically you have to give concrete implementation of the abstract property)

    // Error: Property initializers are not allowed in interfaces
//    val number2: Int = 50


    // So we have to define properties with our custom get() method like below
    // This is a concrete property(non-abstract) as we have assigned a value to it here.
//    val number2: Int get() = number * 45 // we can also do it like this
    val number2: Int get() = 45  // interfaces can have properties and these properties don't have to be abstract.
    // you can provide accessors for these properties and sub-interface can override the accessors

    // properties in interfaces don't have the "field" identifier(backing "field") for using in custom get and set
    // method unlike classes


    open fun MyFunction(str: String): String

    // you can't write "open" keyword before the functions of interfaces & if you do so then IDE shows warning that:
    // "Modifier 'open' is redundant for abstract interface members"

}

// we don't have to make interfaces marked with "open" keyword as a class
// we can directly make child interface out of parent interface just like java

interface MySubInterface: MyInterface {

    override val number2: Int
        get() = super.number2 // overriding the accessor

    fun MySubFunction(str: Int): String

}



































