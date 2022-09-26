
open class General(private val value: Int) {
    override fun toString(): String {
        return value.toString()
    }

    operator fun plus(General: General): General {
        return General(value + General.value)
    }
}

class Vector<T : General>(override val size: Int) : ArrayList<T>() {

    operator fun plus(vector: Vector<T>): Vector<General>? {
        if (vector.size != this.size) return null

        val resultVector = Vector<General>(size)
        for (i in 0 until size) {
            resultVector.add(this[i] + vector[i])
        }
        return resultVector
    }
}

fun main() {
    val vector1 = Vector<General>(10)
    for (i in 0 until 10) {
        vector1.add(General(i))
    }
    // vector1: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    val vector2 = Vector<General>(10)
    for (i in 10 until 20) {
        vector2.add(General(i))
    }
    // vector2: [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]

    println(vector1 + vector2)
    // resultVector: [10, 12, 14, 16, 18, 20, 22, 24, 26, 28]
}
