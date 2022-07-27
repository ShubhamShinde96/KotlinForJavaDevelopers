package shubham.learnkotlin.accesmodifiers
import com.sun.org.apache.xpath.internal.operations.Bool

val MY_CONSTANT = 100

fun main() {

    println("MY_CONSTANT: $MY_CONSTANT")

    // default access modifier is "public"

    // In Java, we can't declare a class as private cause if we do so then that class is useless, we can't access
    // that class anywhere, cause in java we can declare only one public class in a file.
    // We can declare nested and inner classes as protected or private
    // In Kotlin, we can declare many public class in single file & if we declare a class as a private it is still accessible to other classes within the same file, cause
    // even we declare something private it is accessible to any function or class which is inside the same file
    // In java we have to keep the classname same as its filename but in kotlin it is not necessary, you can name your cass different from its containing filename.

    val emp = Employee("Shubham")  // This class is declared as private, but we can still access it within the same file.
    println(emp.firstName)
    emp.fullTime = false
    println(emp.fullTime)

    val emp2 = Employee("Sujay", true)
    println(emp2.firstName)
    println(emp2.fullTime)

    val emp3 = Employee("Sumit", false)
    println(emp3.firstName)
    println(emp3.fullTime)

    val car = Car("blue", "toyota", 2015)
    println(car)
    println(emp)

    var emp4 = Employee("Shubham")
    println(emp == emp4) // This will seem strange, even though these two objects are structurally equals you're still
    // going to get false, because you haven't implemented equals() method, you have to do it for regular classes.

    val car2 = Car("blue", "toyota", 2015)
    println(car == car2) // In this case it is comparing structural equality because data class by default implements
    // these methods for you.

    var car3 = car.copy()
    println(car3)

    val car4 = car.copy(year = 2016, color = "green") // change param value while copying object
    println(car4)


}


data class Car(val color: String, val model: String, val year: Int) {

    // So what's the difference between a data class & a simple class which has getter & setter
    // Well... data class gives some functions which are predefined
    // like toString(), equals() & hashCode() , and a copy()
    // although if you want your definition for above-mentioned functions then you can do that too
    // You just have to override those functions & have to write your version of these functions

    // Rules to define data class
    // 1] Primary constructor has to have at-least one parameter
    // 2] All the primary constructor parameter has to marked val or var, if you don't do it then it will not consider those properties for predefined functions like equals(),toString() and rest of the others


}


// This is a top level item, as we are executing main method
// in kotlin all classes are public and final by default
//private class Employee {

//class Employee constructor(firstName : String){// this is verbose way - long way
//class Employee constructor(firstName : String){
class Employee (val firstName : String, fullTime: Boolean = true){ // this is the shortest way by eliminating boilerplate code
//class Employee protected constructor(val firstName : String){  // If you want to change visibility(access modifier) of constructor this is how you have to do that, in this case you have to write the constructor keyword compulsory

//    val firstName: String = firstName // this is a short way

    /*val firstName: String  // this is a verbose way - long way

    init { // init block runs when instance is created.
        this.firstName = firstName  // this is a verbose way - long way of assigning values
    }*/

    /*var fullTime: Boolean = true

    constructor(firstName: String, fulTime: Boolean): this(firstName) {
        // secondary constructor do not declare properties(variables) for us, we have to declare them & assign them
        // just like what we are doing in java
        this.fullTime = fulTime
    }*/

    var fullTime = fullTime

    get() {
        println("Running the custom get")
        return field
    }

    set(value) {
        println("Running the custom set")
        field = value
    }

}




































