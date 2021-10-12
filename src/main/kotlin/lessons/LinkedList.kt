

abstract class LinkedList<T>() {
    enum class CursorStatus {
        NOT_INITIALIZED,
        INITIALIZED
    }

    enum class CommandStatus {
        OK,
        ERR,
        NEVER_PERFORMED
    }
    
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private lateinit var cursor: Node<T>

    private var cursorStatus: CursorStatus = CursorStatus.NOT_INITIALIZED
    private var headStatus: CommandStatus = CommandStatus.NEVER_PERFORMED
    private var tailStatus: CommandStatus = CommandStatus.NEVER_PERFORMED
    private var rightStatus: CommandStatus = CommandStatus.NEVER_PERFORMED

    // command performs only if head is not null
    fun head() {
        head?.let {
            cursor = it
            headStatus = CommandStatus.OK
            return
        }
        headStatus = CommandStatus.ERR
    }

    // command performs only if tail is not null
    fun tail() {
        tail?.let {
            cursor = it
            tailStatus = CommandStatus.OK
            return
        }
        tailStatus = CommandStatus.ERR
    }

    // command performs only if cursor next item is not null
    // move cursor to the next node
    fun right() {
        cursor.next?.let {
            cursor = it
            rightStatus = CommandStatus.OK
            return
        }
        rightStatus = CommandStatus.ERR
    }

    // command performs only if cursor initialized
    // get current cursor value
    fun get(): T {
        return cursor.value
    }

    // command performs only if cursor initialized
    fun putRight(value: T) {
        cursor.next = Node(value)
    }

    // command performs only if cursor initialized
    fun putLeft(value: T) {
        cursor.prev = Node(value)
    }

    // command performs only if cursor initialized and has next or prev node
    fun remove() {
        cursor.next?.let {
            it.prev = cursor.prev
        }
        cursor.prev?.let {
            it.next = cursor.next
        }
        cursor.next?.let {
            cursor = it
            return
        }
        cursor.prev?.let {
            cursor = it
            return
        }
    }

    // command performs only if cursor initialized
    fun replace(newValue: T) {
        cursor.value = newValue
    }

    // command performs only if cursor initialized
    fun find(value: T) {
        var node = cursor.next
        while (node != null) {
            if (node.value == value) {
                cursor = node
                return
            }
            node = node.next
        }
    }

    // remove all node which contain value
    fun removeAll(value: T) {
        var node = head
        while (node != null) {
            if (node.value == value) {
                // head contains value to remove
                if (node == head) {
                    head = head!!.next
                    if (head!!.next != null) {
                        head!!.next!!.prev = null
                    }
                }
                // node is in center
                val nodePrev = node.prev
                val nodeNext = node.next
                if (nodePrev != null) {
                    nodePrev.next = node.next
                }
                if (nodeNext != null) {
                    nodeNext.prev = nodePrev
                }
            }
            node = node.next
        }
    }

    fun clear() {
        tail = null
        head = null
        cursorStatus = CursorStatus.NOT_INITIALIZED
        headStatus = CommandStatus.NEVER_PERFORMED
        tailStatus = CommandStatus.NEVER_PERFORMED
        rightStatus = CommandStatus.NEVER_PERFORMED
    }

    // put node to the end of list
    fun addTail(newNode: Node<T>) {
        // list is empty
        if (head == null) {
            head = newNode
            cursor = head!!
            cursorStatus = CursorStatus.INITIALIZED
            return
        }
        // list has only one item
        if (tail == null) {
            tail = newNode
            head!!.next = tail
            tail!!.prev = head
            return
        }
        // list has head and tail
        tail!!.next = newNode
        newNode.prev = tail
        tail = newNode
    }

    // command performs only if cursor initialized
    fun isHead(): Boolean {
        return cursor == head
    }

    // command performs only if cursor initialized
    fun isTail(): Boolean {
        return cursor == tail
    }

    fun isCursor(): Boolean {
        return cursorStatus != CursorStatus.INITIALIZED
    }

}
