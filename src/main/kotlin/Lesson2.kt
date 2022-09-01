
// пример специализация класса родителя
open class User(
    val email: String,
    val firstName: String,
    val secondName: String
) {
    open fun fullInfo(){
        return "$email $firstName $secondName"
    }
}

class Student(
    val studentId: String,
    email: String,
    firstName: String,
    secondName: String
) : User(email, firstName, secondName) {
    
    override fun fullInfo() {
        return "$email %firstName $secondName userId:$studentId"
    }
}
