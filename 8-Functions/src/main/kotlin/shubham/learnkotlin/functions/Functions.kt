package shubham.learnkotlin.functions

fun main() {

    // default return type of function is "unit".

    println(labelMultiply(3, 4, "The result is: "))
    println(labelMultiply(label = "The result is: ", operand2 = 3, operand1 = 4))
    println(labelMultiply(2, 8))

    val emp = Employee("Shubham")
    println(emp.upperCaseFirstName())

    val car1 = Car("Blue", "Toyota", 2020)
    val car2 = Car("Red", "Ford", 2019)
    val car3 = Car("Gray", "Ford", 2018)

    printColor(car1, car2, car3, str = "str")

    val manyCars = arrayOf(car1, car2, car3)
    printColor(*manyCars, str = "ste")

    val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()

    val lotsOfCars = arrayOf(*manyCars, *moreCars, car4) // using spread operator (*) to decompose array to pass as vararg param.

    for (c in lotsOfCars) {
        println(c)
    }


//    println(Utils().upperFirstAndLast("shubham"))
    println("shubham".upperFirstAndLast()) // calling extension function, here "shubham" string is receiver object/type
    println("shubham".upperFirstAndLastCase()) // calling extension function, here "shubham" string is receiver object/type


}

// Extension function basically creates an illusion of associating the functions to particular class like string class which we don't have access to modify
// String.upperFirstAndLast is the receiver type it's the type ware were pseudo extending
fun String.upperFirstAndLast(): String {

//    val upperFirst = str.substring(0, 1).uppercase() + str.substring(1)

                     // so "shubham" is substituted here 🠗
//    val upperFirst = this.substring(0, 1).uppercase() + this.substring(1)
    val upperFirst = substring(0, 1).uppercase() + substring(1) // here you can also remove this substitution like that.

    println("upperFirst: ${upperFirst.substring(0, upperFirst.length - 1)}")

    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).uppercase()
}

fun String.upperFirstAndLastCase(): String {

    val upperFist = substring(0, 1).uppercase() + substring(1)

    return upperFist.substring(0, upperFist.length - 1) +
            upperFist.substring(upperFist.length - 1).uppercase()
}

/*fun labelMultiply(operand1: Int, operand2: Int, label: String) : String {

    return ("$label ${operand1 * operand2}")
}*/

//fun labelMultiply(operand1: Int, operand2: Int, label: String) : String = ("$label ${operand1 * operand2}")

// inline
inline fun labelMultiply(operand1: Int, operand2: Int, label: String = "The answer is: ") = ("$label ${operand1 * operand2}")
// when inline function is compiled it's body is directly substituted for the function call, in other words it's not compiled
// to a function at all, it is compiled to its body.
// inline is often done when a function has lambda expression for a parameter, because lambdas require the creation of a class
// and its object under the cover, so by inlining a function that takes a lambda this extra overhead of creating a class & object
// isn't required.
// Not all functions can be inlined, it will depend on how any function parameters are being used, now the JVM is smart enough
// So it will make fun inline for you where it thinks it is necessary even if you've asked to do so.
// So here you'll notice a warning on inline keyword, basically it is saying that here making this function inline is not
// providing any benefit for performance, as Inlining works best for "Functions with Parameters of Functional Types"
// basically "Lambda Functions".


class Employee(val firstName: String) {

    fun upperCaseFirstName() = firstName.uppercase()

}


// To pass variable number of arguments we should use(accept) vararg parameter
// Each function can have at-most 1 vararg parameter otherwise compiler will give error
fun printColor(vararg cars: Car, str: String) {

    for (car in cars) {
        println(car.color)
    }
}


data class Car(var color: String, var model: String, val year: Int) {


}