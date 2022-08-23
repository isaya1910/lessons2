

abstract class HashTable <T> {
    // postcondition: new value was inserted
    abstract fun insert(value: T)

    // precondition: value exist in hash table
    // postcondition: value was deleleted
    abstract fun delete(value: T)

    // return true if value exist
    abstract fun contains(value: T): Boolean

    abstract fun getInsertStatus(): Int
    abstract fun getDeleteStatus(): Int
}

abstract class PowerSet<T>(maxSize: Int): HashTable<T>() {

    // precondition: set size is less than maxsize
    // postcondition: new item was added
    abstract override fun insert(value: T)

    abstract fun intersection(set: Set<T>): Set<T>

    abstract fun union(set: Set<T>): Set<T>

    abstract fun difference(set: Set<T>): Set<T>

    abstract fun isSubset(set: Set<T>): Boolean
}
