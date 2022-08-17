// constructor with maxSize of stack and default value is 32
class BoundedStack<T>(private val maxSize: Int = 32) {
    companion object {
        const val POP_NIL = 0
        const val POP_OK = 1
        const val POP_ERR = 2
        const val PEEK_NIL = 0
        const val PEEK_OK = 1
        const val PEEK_ERR = 2
        const val PUSH_NIL = 0
        const val PUSH_OK = 1
        const val PUSH_ERR = 2
    }

    private val stack: MutableList<T> = mutableListOf()
    private var peekStatus = POP_NIL
    private var popStatus = PEEK_NIL
    private var pushStatus = PUSH_NIL

    // precondition: stack size is less than maxSize
    // postcondition: item was added
    fun push(item: T) {
        if (stack.size < maxSize) {
            pushStatus = PUSH_OK
            stack.add(item)
            return
        }
        pushStatus = PUSH_ERR
    }

    // precondition: stack is not empty
    // postcondition: last item is deleted
    fun pop() {
        if (stack.isNotEmpty()) {
            val itemToDelete = stack.last()
            stack.remove(itemToDelete)
            popStatus = POP_OK
            return
        }
        popStatus = POP_ERR
    }

    // precondition: stack is not empty
    fun peek(): T? {
        if (stack.isNotEmpty()) {
            peekStatus = PEEK_OK
            return stack.last()
        }
        peekStatus = PEEK_ERR
        return null
    }

    fun size(): Int {
        return stack.size
    }

    // postcondition: all items are removed from stack and statuses are set for initial values
    fun clear() {
        stack.clear()
        peekStatus = PEEK_NIL
        popStatus = POP_NIL
        pushStatus = POP_NIL
    }

    // Statuses request
    fun getPushStatus(): Int {
        return pushStatus
    }

    fun getPopStatus(): Int {
        return popStatus
    }

    fun getPeekStatus(): Int {
        return peekStatus
    }
}
