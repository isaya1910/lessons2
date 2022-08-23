
abstract class HashTable <T> {
    // postcondition: new value was inserted
    abstract fun insert(value: T)

    // precondition: value exist in hash tavle
    // postcondition: value was deleleted
    abstract fun remove(value: T)

    // return true if value exist
    abstract fun find(value: T): Boolean

    abstract fun getInsertStatus(): Int
    abstract fun getDeleteStatus(): Int
}
