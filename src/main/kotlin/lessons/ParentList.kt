
abstract class ParentList<T> {

    companion object {
        const val HEAD_NIL = 0
        const val HEAD_OK = 1
        const val HEAD_ERR = 2
        const val TAIL_NIL = 0
        const val TAIL_OK = 1
        const val TAIL_ERR = 2
        const val RIGHT_NIL = 0
        const val RIGHT_OK = 1
        const val RIGHT_ERR = 2
        const val PUT_RIGHT_NIL = 0
        const val PUT_RIGHT_OK = 1
        const val PUT_RIGHT_ERR = 2
        const val PUT_LEFT_NIL = 0
        const val PUT_LEFT_OK = 1
        const val PUT_LEFT_ERR = 2
        const val ADD_TAIL_NIL = 0
        const val ADD_TAIL_OK = 1
        const val ADD_TAIL_ERR = 2
        const val REMOVE_NIL = 0
        const val REMOVE_OK = 1
        const val REMOVE_ERR = 2
        const val REPLACE_NIL = 0
        const val REPLACE_OK = 1
        const val REPLACE_ERR = 2
        const val FIND_NIL = 0
        const val FIND_OK = 1
        const val FIND_ERR = 2
    }

    protected class Node<T>(var value: T) {
        var prev: Node<T>? = null
        var next: Node<T>? = null
    }

    protected var head: Node<T>? = null
    protected var tail: Node<T>? = null
    protected var cursor: Node<T>? = null
    protected var size = 0
    private var headStatus = HEAD_NIL
    private var tailStatus = TAIL_NIL
    private var findStatus = FIND_NIL
    private var rightStatus = RIGHT_NIL
    protected var putRightStat = PUT_RIGHT_NIL
    protected var putLeftStat = PUT_LEFT_NIL

    // precondition: linked list is not empty
    // postcondition: cursor was set to head
    fun head() {
        if (head == null) {
            headStatus = HEAD_ERR
            return
        }
        headStatus = HEAD_OK
        cursor = head
    }

    // precondition: linked list is not empty
    // postcondition: cursor was set to tail
    fun tail() {
        if (tail == null) {
            tailStatus = TAIL_ERR
            return
        }
        tailStatus = TAIL_OK
        cursor = tail
    }

    // precondition: cursor is not tail and list is not empty
    // postcondition: cursor was set to next item
    open fun right() {
        if (cursor == null) {
            rightStatus = RIGHT_ERR
            return
        }
        if (cursor == tail) {
            rightStatus = RIGHT_ERR
            return
        }
        cursor = cursor!!.next
    }

    // precondition: linked list is not empty
    // postcondition: new item was added next to cursor
    abstract fun putRight(item: T)

    // precondition: linked list is not empty
    // postcondition: new item was added  before cursor
    abstract fun putLeft(item: T)

    // precondition: linked list is not empty
    // postcondition: item of cursor removed, cursor was set to previous item if exist, otherwise to the next
    abstract fun remove()

    // postcondition: linked list became empty
    open fun clear() {
        tail = null
        head = null
        headStatus = HEAD_NIL
        tailStatus = TAIL_NIL
        findStatus = FIND_NIL
        rightStatus = RIGHT_NIL
        putRightStat = PUT_RIGHT_NIL
        putLeftStat = PUT_RIGHT_NIL
    }

    // postcondition: tail was set to new added item
    open fun addTail(item: T) {
        size++
    }

    // precondition: linked list is not empty
    // postcondition: cursor item replaced by new added item
    fun replace(item: T) {
        cursor!!.value = item
    }

    // postcondition: cursor was set to the item if item was found
    fun find(item: T) {
        val it = cursor!!.next
        while (it != null) {
            if (it == item) {
                cursor = it
                findStatus = FIND_OK
                return
            }
        }
        findStatus = FIND_ERR
    }

    // postcondition: all items which equal to argument item were deleted
    abstract fun removeAll(item: T)


    // precondition: linked list is not empty
    fun get(): T {
        return cursor!!.value
    }

    fun size(): Int {
        return size
    }

    fun isHead(): Boolean {
        return cursor == head
    }

    fun isTail(): Boolean {
        return cursor == tail
    }

    abstract fun isValue(): Boolean

    fun getHeadStatus(): Int {
        return headStatus
    }

    fun getTailStatus(): Int {
        return tailStatus
    }

    fun getRightStatus(): Int {
        return rightStatus
    }

    fun getPutRightStatus(): Int {
        return putRightStat
    }

    abstract fun getPutLeftStatus(): Int

    abstract fun getRemoveStatus(): Int

    abstract fun getReplaceStatus(): Int

    abstract fun getFindStatus(): Int
}

class LinkedList<T> : ParentList<T>() {


    override fun right() {
        super.right()
        TODO("Not yet implemented")
    }

    override fun clear() {
        super.clear()
        TODO("Not yet implemented")
    }

    override fun putRight(item: T) {
        TODO("Not yet implemented")
    }

    override fun putLeft(item: T) {
        TODO("Not yet implemented")
    }

    override fun remove() {
        TODO("Not yet implemented")
    }

    override fun removeAll(item: T) {
        TODO("Not yet implemented")
    }
    override fun isValue(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPutLeftStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun getRemoveStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun getReplaceStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun getFindStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun addTail(item: T) {
        TODO("Not yet implemented")
    }

}


class TwoWayList<T> : ParentList<T>() {


    override fun right() {
        super.right()
        TODO("Not yet implemented")
    }

    override fun clear() {
        super.clear()
        TODO("Not yet implemented")
    }

    override fun putRight(item: T) {
        TODO("Not yet implemented")
    }

    override fun putLeft(item: T) {
        TODO("Not yet implemented")
    }

    override fun remove() {
        TODO("Not yet implemented")
    }

    override fun removeAll(item: T) {
        TODO("Not yet implemented")
    }
    override fun isValue(): Boolean {
        TODO("Not yet implemented")
    }


    override fun getPutLeftStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun getRemoveStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun getReplaceStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun getFindStatus(): Int {
        TODO("Not yet implemented")
    }

    override fun addTail(item: T) {
        TODO("Not yet implemented")
    }

}
