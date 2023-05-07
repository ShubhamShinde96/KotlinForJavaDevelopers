package shubham.learnkotlin.covariance

fun main() {

    val shortsList: MutableList<Short> = mutableListOf(1, 2, 3, 4, 5)

//    convertToInt(shortsList) // 2] but as soon as we change to mutable list it is showing error that we expect mutable list of numbers here, not mutable list of shorts
    // so here we're wondering if it's working with list then why it's giving error with mutableList & shorts are number too.
    // 3] This is happening because list is a class & not a type

    // when we're discussing generics, using type and subtype is more accurate than using class and subclass
    // for ex: list is a class, list is not a type but list of string "List<String>" is a type & this same applies to int, short
    // and so on..
    // and list of int or short (List<Int> or List<Short>) is a subtype of list of number (List<Number>)
    // List<Int> isn't a subclass of a List<Number> because we're not extending anything, it's more that we're saying List<Number> should be
    // able to accept a List<Int> because List<Int> is a subtype of List<Number>, so it's imp to understand the distinction between a subclass
    // and subtype. we know that in our case short is a subclass of Number but is Short is subtype of Number

    // Now the same goes for supertype, now in this case List<Number> is a supertype of List<Short>, that's how we'd say it.
    // now one wrinkle here is nullable vs non-nullable types, a nullable type is a wider type than the non-nullable type, meaning that if you
    // have a nullable type then you can store  non-nullable types into it but you can't off-course you can't do it the other way around.
    // If you have a non-nullable variable then you can't store a nullable type into it.

    // Now this brings us to covariance, what we want to do here is we want to treat a List<Short> like a List<Number> and remember we were
    // able to do that when we were using immutable list List<Short>. So what we're saying is we want a List<Short> to be a subtype
    // of List<Number> & if we want this subtyping to be preserved when working with generics then we have to declare the type parameter to be
    // covariant.
    // The collection interface is covariant and the mutable collections interface is not covariant and if we want List<Short> to be treated as
    // List<Number> then List<Short> has to be a subtype of List<Number> and if we want this subtyping to be preserved then we have to declare the
    // parameter as covariant, so if we're saying the immutable collection is covariant but mutable collection is not then now maybe we're getting
    // a hint why this has worked with immutable list but not with a mutable-list.
    // When we're dealing with something that's covariant the subtyping is preserved. So when something is covariant a List<Short> is a subtype of
    // a List<Number> but something is not covariant that's not true.
    // so let's create a class ca   lled Flower

}

fun convertToInt(collection: MutableList<Number>) { // 1] if we use list then its not giving error while calling this function with List<Short>

    for(num in collection) {
        println(num.toInt())
    }

    collection.add(25) // see!, here you are adding it int, if you use this function and pass list of short then there will be ambiguity created. cause here you're allowed to add any type of number, be it int, float, double
    // That's why there is restriction of covariant classes
}

fun waterGarden(garden: Garden<Flower>) {


}

fun tendGarden(roseGarden: Garden<Rose>) {

    waterGarden(roseGarden) // an we get an similar error here like what we got with MutableList<Short> and MutableList<Number>
    // it's gonna say that waterGarden() wants a Garden<Flower> and here we're passing a Garden<Rose> and we know the Rose is a subclass
    // of Flower and still we're getting this error.
    // Now this is happening because Garden class is what's called "Invariant", that's why when we ask for Garden<Flower> we can only provide
    // Garden<Flower>
}

open class Flower {

}

class Rose: Flower() {

}

//class Garden<T: Flower> { // We are saying that the Garden is some type of Flower.
class Garden<out T: Flower>(private var something: T) { // Making the class covariant using "out" keyword
                    // remove private

    // This class is invariant

    val flowers: List<T> = listOf()

    fun pickFLower(i: Int): T = flowers[i]
//    fun plantFlower(flower: T) { // Uncomment this to see the error
        // Error: Type parameter T is declared as 'out' but occurs in 'in' position in type T
        // kotlin has notion of in and out positions
        // 'in' position is function parameter whereas 'out' position is return parameter

        // so error is because we are trying to use something as 'out' at 'in' position.
//    }
}