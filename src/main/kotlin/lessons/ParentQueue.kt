
abstract class ParentQueue<T> {
    companion object {
        const val REMOVE_FRONT_NIL = 0
        const val REMOVE_FRONT_OK = 1
        const val REMOVE_FRONT_ERR = 2
        const val GET_FRONT_NIL = 0
        const val GET_FRONT_OK = 1
        const val GET_FRONT_ERR = 2
    }

    private var removeFrontStat = REMOVE_FRONT_NIL
    private var getFrontStat = GET_FRONT_NIL
    protected val list = mutableListOf<T>()

    // postcondition: item was added to the end of queue
    fun addTail(item: T) {
        list.add(item)
    }

    // precondition: queue is not empty
    // postcondition: first queue item was removed and returned
    fun removeFront() {
        if (list.isEmpty()) {
            removeFrontStat = REMOVE_FRONT_ERR
            return
        }
        list.removeAt(0)
        removeFrontStat = REMOVE_FRONT_OK
    }

    // precondition: queue is not empty
    fun getFront(): T? {
        if (list.isEmpty()) {
            getFrontStat = GET_FRONT_ERR
            return null
        }
        getFrontStat = GET_FRONT_OK
        return list.first()
    }

    fun size(): Int {
        return list.size
    }

    fun getRemoveFrontStatus(): Int {
        return removeFrontStat
    }

    fun getGetFrontStatus(): Int {
        return getFrontStat
    }
}

class Deque<T> : ParentQueue<T>() {
    companion object {
        const val REMOVE_TAIL_NIL = 0
        const val REMOVE_TAIL_OK = 1
        const val REMOVE_TAIL_ERR = 2
        const val GET_TAIL_NIL = 0
        const val GET_TAIL_OK = 1
        const val GET_TAIL_ERR = 2
    }

    private var getTailStat = GET_TAIL_NIL
    private var removeTailStat = REMOVE_TAIL_NIL

    // postcondition: item was added to the start of the queue
    fun addFront(item: T) {
        list.add(0, item)
    }

    // precondition: queue is not empty
    fun removeTail() {
        if (list.isEmpty()) {
            removeTailStat = REMOVE_TAIL_ERR
            return
        }
        removeTailStat = REMOVE_TAIL_OK
        list.removeAt(list.size - 1)
    }

    // precondition: queue is not empty
    fun getTail(): T? {
        if (list.isEmpty()) {
            getTailStat = GET_TAIL_ERR
            return null
        }
        getTailStat = GET_TAIL_OK
        return list.last()
    }
    
    fun getRemoveTailStatus(): Int {
        return removeTailStat
    }

    fun getGetTailStatus(): Int {
        return getTailStat
    }
}

class Queue<T> : ParentQueue<T>()
