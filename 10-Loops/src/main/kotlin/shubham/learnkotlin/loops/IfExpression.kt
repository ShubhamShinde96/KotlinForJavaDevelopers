package shubham.learnkotlin.loops

import kotlin.reflect.typeOf

fun main() {

    var num: Int

    val someCondition = 69 < 22
    val num2 = if(someCondition) 50 else 582

    val result = if(someCondition) {
        println("Something")
        50
    } else {
        println("Something else")
        592
    }

    println("Result: $result")

    println("The result of if expression is:${if(someCondition) {
        println("Something")
        50
    } else {
        println("Something else")
        592
    }}")

    val x = if(someCondition) {
        println("Something")
    } else {
        println("Something else")
    }

    println("Type of x is ${x.javaClass}")

}