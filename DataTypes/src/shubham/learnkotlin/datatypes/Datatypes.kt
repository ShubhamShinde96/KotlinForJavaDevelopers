package shubham.learnkotlin.datatypes

import java.math.BigDecimal

fun main(args : Array<String>) {

    val myInt = 10
    var myLong = 22L // L suffix for long is also used in kotlin

    myLong = myInt.toLong()

    val myByte : Byte = 111
    var myShort : Short
    myShort = myByte.toShort()


    var myDouble = 65.23 // it will get default datatype as Double
    println(myDouble is Double)

    val myFloat = 838.549f
    println("This is a float ${myFloat is Float}")
    // so java automatically widens the number when assigned but in kotlin we have to explicitly call toFloat() or toDouble() such functions to do it so.


    val char : Char = 'b'
    val myCharInt = 65
    println(myCharInt.toChar()) // Output : 'A'

    // 'Any' ,  'Unit' & 'Nothing'


    val names = arrayOf("John", "Jane", "Jill", "Joe")

    val longsArray1 = arrayOf(1L, 2L, 3L)
    val longsArray2 = arrayOf<Long>(1, 2, 3, 4)
    val longsArray3 = arrayOf(1, 2, 3, 4)

    println(longsArray1 is Array<Long>)
    println(longsArray2 is Array<Long>)
    println(longsArray3 is Array<Int>)

//    println(longsArray1[2])


    val evenNumbers = Array(16) {
        i -> i * 2
    }

    for (number in evenNumbers) {
//        println(number)
    }


    val lotsOfNumbers = Array(100000) {
        i -> i + 1
    }

    val allZeroes = Array(100) {
//        i -> 0
        0 // shorter way
    }


    var someArray: Array<Int>
    someArray = arrayOf(1, 2, 3, 4)

    for(number in someArray) {
        println(number)
    }

    someArray = Array(6) {
        i -> (i + 1) * 10
    }

    for(number in someArray) {
        println(number)
    }

    val mixedArray = arrayOf("Hello", 22, BigDecimal(10.5), 'a')

    for(element in mixedArray) {
        println(element)
    }

    val myIntArray = arrayOf(3, 9, 434, 2, 33.8)// so passing this array to java class function which requires int array will not work
        // as it requires primitive int array, so you have to use intArrayOf
    // Using primitive types for arrays always gives performance boost, so always try to use primitive types for arrays
//    DummyClass().printNumbers(myIntArray)
    val myIntArray2 = intArrayOf(3, 9, 434, 2, 33) // like this one here
    DummyClass().printNumbers(myIntArray2)

    val someOtherArray = IntArray(5)
    for (number in someOtherArray) {
        println(number)
    } // output will be 0, 0, 0, 0, 0
    // So to create an empty array

    DummyClass().printNumbers(evenNumbers.toIntArray())

    val convertedIntArray: Array<Int> = myIntArray2.toTypedArray()





}