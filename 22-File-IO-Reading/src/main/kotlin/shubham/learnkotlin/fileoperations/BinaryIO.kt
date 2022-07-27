package shubham.learnkotlin.fileoperations

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileReader

fun main() {

    // Kotlin doesn't have its own IO classes so it has added some extension function on JDKs IO classes
    // to make them easier to use so you can call extension function readBytes but it has 2GB limitation
    // So the best way is to use java classes

    val di = DataInputStream(FileInputStream("testfile.bin"))
    var si: String

    try {
        while (true) {
            si = di.readUTF()
            println(si)
        }
    }
    catch (e: EOFException){

    }

    println("----------------- F I N I S H E D -----------------------")


//    try (fr: FileReader = )
//
}






































