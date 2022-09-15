
class General {
    fun deepCopy(): General {
        val json = Gson().toJson(this)
        return Gson().fromJson(json, MyCustomClass::class.java)
    }

    fun serialize(): String {
        return Gson().toJson(this)
    }

    fun deserialize(json: String): General {
        return Gson().fromJson(json, General::class.java)
    }

    fun print() {
        print(serialize())
    }

    fun getType(): String {
        return this.javaClass.name
    }

    inline fun <reified T> isType(): Boolean {
        return this is T
    }
}
