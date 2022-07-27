package shubham.learnkotlin.lambdas

import java.lang.StringBuilder

fun main() {

//    run { println("I'm in a lambda") }

    val employees = listOf(Employee("Shubham", "Shinde", 2021),
                            Employee("Sujay", "Salunkhe", 2019),
                            Employee("Ajikya", "Kadam", 2018),
                            Employee("Sumit", "Salunkhe", 2019)
    )

    println(employees.minByOrNull { e -> e.startYear })

    // We can replace lambda with member reference like this
    println(employees.minByOrNull(Employee::startYear))

    // This is how you can explicitly specify the type of lambda parameter
    println(employees.minByOrNull { e: Employee -> e.startYear })

    // When there is only one parameter and if the compiler can infer it then we can use "it" & we don't have to declare the parameter
    println(employees.minByOrNull { it.startYear })


    var num = 10

    run {
        num += 15
        println(num)

        // In JAVA: You can only access final local variables in lambdas & anonymous classes
    }


    // accesing function using member reference
    println("***************************")
    run {::topLevel} // This does not work!! This way is shown by instructor of course
    topLevel()
    println("***************************")
    // It depends on coading style where what you want to use -> either lambda or member reference
    // If you're working for client then maybe that client is following certain set of rules(coading styles)
    // in which you'll be told to use either "lambda" or "member reference"



    println(countTo100())
//    println(countTo100With())
    println(countTo100Apply())


    findByLastName(employees, "Shinde")
    findByLastName(employees, "Wilson")


    "Some String".apply someString@ {

        "Another String".apply {
//            println(this.lowercase())
            println(lowercase())
            println(this@someString.uppercase())


        }
    }
}


fun topLevel() = println("I'm in a function!")


fun useParameter(employees: List<Employee>, num: Int) {

    employees.forEach {
        println(it.firstName)
        println(num)
    }

}

data class Employee(val firstName: String, val lastName: String, val startYear: Int){

    /*override fun toString(): String {
        return "Employee(firstName='$firstName', lastName='$lastName', startYear=$startYear)"
    }*/
}


fun countTo100(): String {

    val numbers = StringBuilder()

    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)

    return numbers.toString()
}

fun countTo100With() =
        // we're using expression body, so we don't need to return statement & we also don't need return-type as well
    with(StringBuilder()) {

        for (i in 1..99) {
            append(i)
            append(", ")
        }
        this.append(100) // <- You can also refer to instance using this inside receiver
        toString()
    }


fun countTo100Apply() =
// we're using expression body, so we don't need return statement & we also don't need return-type as well
//    val numbers = StringBuilder()

    StringBuilder().apply {

        for (i in 1..99) {
            append(i)
            append(", ")
        }
        this.append(100) // <- You can also refer to instance using this inside receiver
//        toString() // in apply we don't need to return it, apply will return the instance that you invoked apply with,
        // like in this case the instance is StringBuilder()
    }


fun findByLastName(employees: List<Employee>, lastName: String) {

    employees.forEach returnBlock@ {

        if(it.lastName.lowercase().equals(lastName.lowercase())){

            println("Yes, there's an employee with last name $lastName")
            return@returnBlock // this will only return from the forEach block so code after that from function will continue executing
        }
    }

    // so this will get printed even though forEach() block finds the lastName match, if you don't want this
    // behaviour then use only "return" so this will return to function, currently "return@returnBlock" is
    // returning to forEach() block only.
    println("Nope, there's no employee with last name: $lastName")
}

