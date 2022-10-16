/*
  Класс машины и класс двигатель. 
  У машины можеть быть разные потомки, например седаны или внедорожники и тд, у каждого из них могут быть свои двигатели со своими разичными видами
*/

interface Car {
    fun getEngine(): Engine
}

@JvmInline
value class HorsePower(val value: Int)

interface Engine {
    fun getPower(): HorsePower
}

object ElectricEngine: Engine {
    override fun getPower(): HorsePower {
        return HorsePower(1000)
    }

}

class ElectricCar: Car {
    override fun getEngine(): Engine {
        return ElectricEngine
    }
}
