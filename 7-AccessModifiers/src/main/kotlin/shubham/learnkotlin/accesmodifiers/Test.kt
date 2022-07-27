package shubham.learnkotlin.accesmodifiers

fun main() {

    var emp4 = Employee2("Shubham", false)

    println("${emp4.firstName} & ${emp4.fullTime}")

    emp4.fullTime = false
    emp4.firstName = "Sujay"

    println("${emp4.firstName} & ${emp4.fullTime}")

    val equality1 = Equality("Shubham", "Shinde")
    val equality2 = Equality("Sujay", "Salunkhe")
    val equality3 = equality1

    println("Equal? = ${equality1 == equality2}") // Compares structural equality as "equals" method overridden and written the custom comparing logic for structural equality
    // If this was data class and if these params had declared under constructor with val or var then we didn't needed
    println("Equal Ref with diff objs ? = ${equality1 === equality2}")
    println("Equal Ref with same objs ? = ${equality1 === equality3}")

}


class Employee2(firstName: String, fullTime: Boolean = true) {

    var firstName = firstName
    get() {
        return field
    }
    set(value) {
        field = "$value Shinde"
    }


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

class Equality(var fistName: String, var lastName: String) {

    override fun equals(other: Any?): Boolean {  // if this method exist with the same type of definition then == will compare
                                                // structural equality
//        return super.equals(other)

        if(other is Equality && this.fistName == other.fistName && this.lastName == other.lastName) {
            return true
        }
        return false
    }

}