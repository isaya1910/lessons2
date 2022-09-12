
open class Plane {
    protected open val speed = 800
    open fun showSpeed() {
        println("base speed:$speed")
    }
}

class F15Plane : Plane() {
    override val speed = 1600
    override fun showSpeed() {
        println("base speed:$speed") 
    }
}

fun main() {
    val plane = Plane()
    // base speed:800
    plane.showSpeed()
    
    val f15Plane: Plane = F15Plane()
    // динамическое связывание: base speed:1600
    f15Plane.showSpeed()
}
