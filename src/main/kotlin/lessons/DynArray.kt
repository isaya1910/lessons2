
abstract class DynArray<T>(protected var capacity: Int = 16) {
    companion object {
        const val INSERT_NIL = 0
        const val INSERT_OK = 1
        const val INSERT_ERR = 2
        const val REMOVE_NIL = 0
        const val REMOVE_OK = 1
        const val REMOVE_ERR = 2
        const val GET_NIL = 0
        const val GET_OK = 1
        const val GET_ERR = 2
    }

    protected var insertStat = INSERT_NIL
    protected var removeStat = REMOVE_NIL
    protected var getStat = GET_NIL
    protected var count = 0
    
    // index is less than DynArray size and non negative
    abstract fun get(index): T

    // postcondition: size of DynArray incremented by one and item appended to the end of DynArray
    abstract fun append(item: T)

    // precondition: index is less than DynArray size and non negative
    // postcondition: item was added to the given index and items after shifted right
    abstract fun insert(item: T, index: Int)

    // precondition: index is less than DynArray size and non negative
    // postcondition: item was removed from the given index and items after shifted left, size decremented by one
    abstract fun remove(index: Int)

    fun size(): Int {
        return count
    }
    
    fun getGetStatus(): Int {
        return getStat
    }

    fun getInsertStatus(): Int {
        return insertStat
    }

    fun getRemoveStatus(): Int {
        return removeStat
    }
}

class IntDynArray : DynArray<Int>() {
    private fun changeCapacity(newCapacity: Int) {
        capacity = newCapacity
        array = this.array.copyOf(newCapacity)
    }

    private var array = Array<Int?>(capacity) {
        null 
    }
    
    override fun get(index: Int) {
        if (index >= count || index < 0) {
            getStat = GET_ERR
            return
        }
        getStat = GET_OK
        return array[index]
    }

    override fun append(item: Int) {
        if (count == capacity) {
            changeCapacity(capacity * 2)
        }
        array[count] = item
        count++
    }

    override fun insert(item: Int, index: Int) {
        if (index == count) {
            append(item)
            return
        }
        if (index >= count || index < 0) {
            insertStat = INSERT_ERR
            return
        }
        if (index == capacity) {
            changeCapacity(capacity * 2)
        }
        count++
        for (i in count - 1 downTo  index + 1) {
            array[i] = array[i - 1]
        }
        array[index] = item
        insertStat = INSERT_OK
    }

    override fun remove(index: Int) {
        if (index >= count || index < 0) {
            removeStat = REMOVE_ERR
            return
        }
        for (i in range(index, count - 1)) {
            array[i] = array[i + 1]
        }
        count --
        removeStat = REMOVE_OK
        val capacityPercent = count.toFloat()/capacity.toFloat()
        val newCapacity = (capacity * 2)/3

        if (capacityPercent < 0.5f && newCapacity >= 16) {
            capacity = newCapacity
            return
        }
        if (capacityPercent < 0.5f && newCapacity < 16) {
            capacity = 16
        }
    }
}

