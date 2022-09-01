
// inheritance example
open class User(
    val email: String,
    val firstName: String,
    val secondName: String
)

class Student(
    val studentId: String,
    email: String,
    firstName: String,
    secondName: String
) :
    User(email, firstName, secondName)



// composition example
interface Teacher {
    fun teach()
}

class MathTeacher: Teacher {
    override fun teach() {
        print("teach math")
    }

}

class MBAStudent: Teacher by MathTeacher() {
    fun learn() {
        print("learn economic")
    }
}

// polymorphism example
open class Money {
    open fun exchange() {
        print("do something")
    }
}

class Dollar: Money() {
    override fun exchange() {
        print("dollar exchange")
    }
}
