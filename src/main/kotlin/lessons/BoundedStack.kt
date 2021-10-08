abstract class BoundedStack<T>(val maxElementsCount: Int = 32) {
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
 
    private val stack = mutableListOf<T>()
    private var popStatus = POP_NIL
    private var peekStatus = PEEK_NIL
    private var pushStatus = PUSH_NIL
 
    fun push(element: T) {
        if (stack.size < maxElementsCount) {
            stack.add(element)
            pushStatus = PUSH_OK
            return
        }
        pushStatus = PUSH_ERR
    }
 
    fun pop() {
        if (stack.isNotEmpty()) {
            stack.removeLast()
            popStatus = POP_OK
            return
        }
        popStatus = POP_ERR
    }
 
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
 
    fun clear() {
        stack.clear()
        popStatus = POP_NIL
        peekStatus = PEEK_NIL
    }
 
    fun getPeekStatus() = peekStatus
 
    fun getPopStatus() = popStatus
 
    fun getPushStatus() = pushStatus
}
