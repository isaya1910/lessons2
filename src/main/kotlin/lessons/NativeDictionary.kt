
abstract class NativeDictionary <T> {

    // postcondition: key value were put into dictionary
    abstract fun put(key: String, value: T)

    // precondition: key value should exist
    // postcondition: value returned
    abstract fun get(key: String): T

    abstract fun getGetStatus(): Int
}
