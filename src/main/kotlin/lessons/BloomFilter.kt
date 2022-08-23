
abstract class BloomFilter<T>(val size: Int) {

    // postcondition: new value added
    abstract fun add(value: T)

    // if false, value 100% doesn't exist
    abstract fun contains(value: T): Boolean
}
