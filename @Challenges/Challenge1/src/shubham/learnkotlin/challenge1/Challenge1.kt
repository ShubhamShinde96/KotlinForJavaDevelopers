package shubham.learnkotlin.challenge1

fun main(args : Array<String>) {

    val hello1 = "Hello"
    val hello2 = "Hello"

    // Challenge : To check referential equality and print the result

    if(hello1 === hello2) {
        println("hello1 & hello2 is referentially equal")
    }

    println("hello1 is referentially equal to hello2: ${hello1 === hello2}")


    // Challenge : To check structural equality and print the result
    println("hello1 is structurally equal to hello2: ${hello1 == hello2}")



    var num = 2988


    val text : Any = "The Any type is the root of the kotlin class hierarchy"

    if(text is String) {
        println(text.uppercase())
    }



    println("""   1
        |  11
        | 111
        |1111 
    """.trimMargin())

}