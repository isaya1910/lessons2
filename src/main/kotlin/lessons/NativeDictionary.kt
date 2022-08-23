
abstract class NativeDictionary <T> {

    // postcondition: key value were put into dictionary or value updated if key was existed
    abstract fun put(key: String, value: T)
    
    // precondition: key value should exist
    // postcondition: key value removed from dictionary
    abstract fun remove(key: String)

    // precondition: key value should exist
    // postcondition: value returned
    abstract fun get(key: String): T

    abstract fun getGetStatus(): Int
    
    abstract fun getRemoveStatus(): Int
}
