package shubham.learnkotlin.nullabilityusingjavainkotlin

fun main() {

    val car = Car("Blue", "Ford", 2015)
    car.color = "Green"
    println(car)

    var model: String = car.model // Now is kotlin is going to treat it as nullable or not nullable.
    println(model.javaClass)

    // This project is not showing error for java annotation of @NotNull and @Nullable, so consider and assume the errors or rewatch the video

//    model = null
    println(model) // So defaultly if not annotade in java as @NotNull then the value is going to be @Nullable in kotlin

    car.variableMethod(5, "hello", "Good Bye", "Shubham")

    val strings = arrayOf("Hello", "GoodBye", "Sujay")
    car.variableMethod(8, *strings) // We have to use spread operator here, we can't pass the array directly

//    car.wantsIntArray(arrayOf(1, 2, 3, 4, 5)) // This does not work
    car.wantsIntArray(arrayOf(1, 2, 3, 4, 5).toIntArray()) // You have to pass intArray, you can convert
    car.wantsIntArray(intArrayOf(1, 2, 3, 4, 5)) // Or you can directly pass intArray

    car.anObject // now you have to cast this object to java.lang.object in order to use the methods available for object
    // Casting
//    (car.anObject as java.lang.Object).notify() // now you can use methods like notify

    // Now static fields from java are treated as a companion objects in kotlin.
    println("x = ${Car.x}")
    println(Car.xString())

}