package shubham.learnkotlin.declarations

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {

    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)

    println(employeeOne === employeeTwo) // to check referential equality we have to use === for that in kotlin
    println(employeeTwo === employeeThree)

    println(employeeOne == employeeTwo) // == will check structural equality in kotlin
    println(employeeTwo == employeeThree)
//    println(employeeOne.equals(employeeTwo)) this does the same as above, checks referential equality unlike java which checks structural equality
//    println(employeeTwo.equals(employeeThree))


    val employeeFour = employeeTwo
    println(employeeFour === employeeTwo)


    println(employeeFour != employeeTwo)
    println(employeeFour !== employeeTwo)
    println(employeeTwo != employeeThree)
    println(employeeTwo !== employeeThree)

    // if you want to check if variable is of certain type then use "is" operator instead of "instanceOf" which is used in Java

    val x = 0x00101101
    val y = 0x00101101

    val something : Any = employeeFour

    if(something is Employee) {
//        (Employee) something -> java approach to cast
        val newEmployee = something as Employee // this is how we do it in kotlin to say treat "something"  as "Employee"
        println(newEmployee.name)
    }


    var number : Int
    number = 10
    number = 20

    val employees : EmployeeSet

    // Wrappers, Hard Keywords & Soft Keywords

    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1])

    val employee1 = Employee("Shubham Shinde", 123)
    employee1.name = "Shubham Sunil Shinde"

//    employee1 = Employee("Om Kadam", 124)

    val employee2 : Employee
    val number2 = 100

    if(number < number2) {
        employee2 = Employee("Sujay Salunkhe", 155)
    } else {
        employee2 = Employee("Ajay Salunkhe", 155)
    }

    println(employee1)

    val change = 4.22
    println("To show the value of change, we have to use it like \$change")

    // when you reference property value from outside the class that's considered to e an expression

    println("The employee's id is $employee1.id")
    println("The employee's id is ${employee1.id}")


    val filePath = """c:\somedir\somedir2""" // to let ignore ide for escape keys

    val eggName = "Humpty"
    val nurseryRhyme = """$eggName dumpty sat on the wall
                      *$eggName dumpty had a great fall
                      *All the king's horses and all the king's men 
                      *Couldn't put $eggName together again."""//.trimMargin("*")

    println(nurseryRhyme)

    // Kotlin REPL - Tools/Kotlin/Kotlin REPL   -> to run the chunk of code or to test the code without having to build & running whole project

}

class Employee (var name: String, val id: Int) {

    override fun equals(obj: Any?): Boolean {

        if(obj is Employee) {
            return name == obj.name && id == obj.id
        }

        return false
    }

    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
    }




}