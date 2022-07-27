fun main() {

    println("Hello")

//    val str: String? = "This isn't null"
//    var str: String? = null
    var str: String? = "This isn't null"
    println("What happens when we do this: ${str?.uppercase()}")

//    val countryCode: String? = bankBranch?.address?.country?.countryCode

    val str2 = str?: "This is the default value"

    println(str2)

//    val whatever = bankBranch?.address?.country ?: "US"

    val something: Any = arrayOf(1, 2, 3, 4)
//    val str3: String = something as? String
//    println(str3) // null because of incompatible casting happened in above line

//    println(str3.uppercase())


    val str4: String? = "This isn't null"
    val str5 = str4!!.uppercase()

//    str = "Now this isn't null"

    str?.let {
        printText(it)
    }


    printText(str!!)

    val anotherStr = "This isn't null"

//    if(str == anotherStr)

    val nullableElementsArray = arrayOfNulls<Int?>(5)
    // This is how you can create array of nulls
    for (i in nullableElementsArray) {
        println(i)
    }

}

fun printText(text: String) {

    println(text)
}
























