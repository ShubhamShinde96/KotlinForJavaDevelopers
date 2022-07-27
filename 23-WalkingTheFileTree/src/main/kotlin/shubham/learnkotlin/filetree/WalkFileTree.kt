package shubham.learnkotlin.filetree

import java.io.File

fun main() {


    File(".").walkTopDown()
        .filter {  it.name.endsWith(".kt")}
        .forEach { println(it) }
}