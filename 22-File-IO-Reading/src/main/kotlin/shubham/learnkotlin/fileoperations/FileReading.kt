package shubham.learnkotlin.fileoperations

import java.io.File

fun main() {

    // Kotlin doesn't have its own I/O classes, what its done is basically created Extension Functions
    // on to the existing java I/O classes

//    val lines = File("testfile.txt").reader().readLines()
    val reader = File("testfile.txt").reader()
    val lines = reader.readText()
    println(lines)
    reader.close()

//    val lines2 = File("testfile.txt").reader().use { it.readText() }
    val lines2 = File("testfile.txt").bufferedReader().use { it.readText() }
    println(lines2)

    val linescrc3 = File("testfile.txt").readText() // not recommended on huge files, max limit is 2 GB
    println(linescrc3)

    File("testfile.txt").reader().forEachLine { println(it) }
    File("testfile.txt").reader().useLines { it.forEach { println(it) } }
                                                // it.forEach is a Terminal operation that we've used here

    // Go to declaration of each function and check commented instruction about whether to close the reader or not & what's the file limit etc.

//    lines.forEach {
//        println(it)
//    }

}