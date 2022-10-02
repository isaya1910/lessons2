
open class A

class B : A()

open class SuperClass {
    open fun foo(): A {
        return A()
    }
}

class SubClass : SuperClass() {
    
    // ковариантность
    override fun foo(): B {
        return B()
    }

    
    // полиморфность
    fun doo(arg: Int) {

    }

    fun doo(arg: String) {

    }

    fun doo(arg: A) {

    }

    fun doo(arg: B) {
        
    }
}
