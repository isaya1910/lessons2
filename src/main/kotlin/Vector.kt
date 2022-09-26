
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
            resultVector.add(this[i].plus(vector[i]))
        }
        return resultVector
    }
}

fun main() {
    val vector1 = Vector<General>(10)
    for (i in 0 until 10) {
        vector1.add(General(i))
    }
    val vector2 = Vector<General>(10)
    for (i in 10 until 20) {
        vector2.add(General(i))
    }

    println(vector1.plus(vector2))
}
