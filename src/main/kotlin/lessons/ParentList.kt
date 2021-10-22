
abstract class ParentList<T>() {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private lateinit var cursor: Node<T>

    // запросы статусов
    var headStatus: CommandStatus = CommandStatus.NEVER_PERFORMED
    var tailStatus: CommandStatus = CommandStatus.NEVER_PERFORMED
    var rightStatus: CommandStatus = CommandStatus.NEVER_PERFORMED

    // пустословие: возможные значения статусов
    enum class CommandStatus {
        OK,
        ERR,
        NEVER_PERFORMED
    }

    // команды
    // предусловие: список не пуст;
    // постусловие: курсор установлен на первый узел в списке
    fun head() {
        head?.let {
            cursor = it
            headStatus = CommandStatus.OK
            return
        }
        headStatus = CommandStatus.ERR
    }

    // предусловие: список не пуст;
    // постусловие: курсор установлен на последний узел в списке
    fun tail() {
        tail?.let {
            cursor = it
            tailStatus = CommandStatus.OK
            return
        }
        tailStatus = CommandStatus.ERR
    }

    // предусловие: правее курсора есть элемент;
    // постусловие: курсор сдвинут на один узел вправо
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

    // предусловие: список не пуст;
    // постусловие: следом за текущим узлом добавлен
    // новый узел с заданным значением
    fun putRight(value: T) {
        cursor.next = Node(value)
    }

    // предусловие: список не пуст;
    // постусловие: перед текущим узлом добавлен
    // новый узел с заданным значением
    fun putLeft(value: T) {
        cursor.prev = Node(value)
    }

    // предусловие: список не пуст;
    // постусловие: текущий узел удалён,
    // курсор смещён к правому соседу, если он есть,
    // в противном случае курсор смещён к левому соседу,
    // если он есть
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

    // предусловие: список не пуст;
    // постусловие: значение текущего узла заменено на новое
    fun replace(newValue: T) {
        cursor.value = newValue
    }

    // постусловие: курсор установлен на следующий узел
    // с искомым значением, если такой узел найден
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

    // постусловие: в списке удалены все узлы с заданным значением
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

    // постусловие: список очищен от всех элементов
    fun clear() {
        tail = null
        head = null
        headStatus = CommandStatus.NEVER_PERFORMED
        tailStatus = CommandStatus.NEVER_PERFORMED
        rightStatus = CommandStatus.NEVER_PERFORMED
    }

    // постусловие: новый узел добавлен в хвост списка
    fun addTail(newNode: Node<T>) {
        // list is empty
        if (head == null) {
            head = newNode
            cursor = head!!
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

    // предусловие: список не пуст
    fun isHead(): Boolean {
        return cursor == head
    }

    // предусловие: список не пуст
    fun isTail(): Boolean {
        return cursor == tail
    }

    // пустословие: количество элементов в списке
    fun size(): Int {
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        return size
    }
}
