
abstract class Queue<T> {
    companion object {
        const val DEQUEUE_NIL = 0
        const val DEQUEUE_OK = 1
        const val DEQUEUE_ERR = 2
    }
    protected var dequeuStat = DEQUEUE_NIL
    
    // postcondition: item was added to the end of queue
    abstract fun enqueue(item: T)

    // precondition: queue is not empty
    // postcondition: first queue item was removed and returned
    abstract fun dequeue(): T
    
    abstract fun size(): Int
    
    fun getDequeueStatus(): Int {
        return dequeuStat
    }
}

class ExampleQueue<T>: Queue<T>() {
    private val list = mutableListOf<T>()
    override fun enqueue(item: T) {
        list.add(item)
    }

    override fun dequeue(): T {
        if (list.isEmpty()) {
            dequeuStat = DEQUEUE_ERR
            throw Exception("queie is empty")
        }
        val item = list.first()
        list.remove(item)
        return item
    }

    override fun size(): Int {
        return list.size
    }
}
