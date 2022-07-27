package shubham.learnkotlin.anotherpackage

import shubham.learnkotlin.inheritance.Department.IT
import shubham.learnkotlin.inheritance.CompanyCommunications as Comm
import shubham.learnkotlin.inheritance.topLevel as TP
import shubham.learnkotlin.inheritance.upperFirstAndLast as ufal

fun main() {

//    topLevel("Hello from another file.")
    TP("Hello from another file.")

//    println(CompanyCommunications.getCopyrightLine())
    println(Comm.getCopyrightLine())

    println(IT.getDepartmentInfo())

//    println("s string to work with".upperFirstAndLast())
    println("s string to work with".ufal())


}