package shubham.learnkotlin.contravariance

import org.intellij.lang.annotations.Flow
import java.io.DataOutput

fun main() {

    val flowerTender = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a ${flower.name}!")
    }

    val roseTender = object: FlowerCare<Rose> { // we're making it an anonymous instance using 'object:' .

        override fun prune(flower: Rose) = println("I'm pruning a rose!")
    }

    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), flowerTender)
//    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), roseTender)
    roseGarden.tendFlower(0)

    val daffodilTender = object : FlowerCare<Daffodill> {
        override fun prune(flower: Daffodill) = println("I'm pruning a daffodil!")
    }
    val daffodilGarden = Garden<Daffodill>(listOf(Daffodill(), Daffodill(), Daffodill()), flowerTender)
//    val daffodilGarden = Garden<Daffodill>(listOf(Daffodill(), Daffodill(), Daffodill()), daffodilTender)
    daffodilGarden.tendFlower(2)

    val flowerTender2 = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a flower")

        fun pick(): Flower = Flower("Some random flower.")
    }


    val roseGarden2 = Garden<Rose>(listOf(Rose(), Rose()), flowerTender2)
    roseGarden2.pickFlower(0)
    val rose: Rose = roseGarden2.pickFlower(0)

}

class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) { //Garden<T: Flower>   <- Garden is of type T: Flower

    fun pickFlower(i: Int) = flowers[i]
//    fun pickFlower(i: Int) = flowerCare.pick(i) // This won't work because we can't actually implement pick in a flowerCare interface.

    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class Flower(val name: String) {

}

class Rose: Flower("Rose") {

}

interface FlowerCare<in T> { // here by saying 'in' we are saying T should accept whatever T is & any of it's superclasses.

    fun prune(flower: T)

//    fun pick(): T
}

class Daffodill: Flower("Daffodil") {

}



















































