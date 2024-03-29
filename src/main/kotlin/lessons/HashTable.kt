
abstract class HashTable <T> {
    // postcondition: new value was inserted
    abstract fun insert(value: T)

    // precondition: value exist in hash table
    // postcondition: value was deleleted
    abstract fun remove(value: T)

    // return true if value exist
    abstract fun contains(value: T): Boolean

    abstract fun getInsertStatus(): Int
    abstract fun getDeleteStatus(): Int
}
