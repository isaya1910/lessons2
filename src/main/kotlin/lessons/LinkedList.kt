
abstract class LinkedList<T> {

    // precondition: linked list is not empty
    // postcondition: cursor was set to head
    abstract fun head()

    // precondition: linked list is not empty
    // postcondition: cursor was set to tail
    abstract fun tail()

    // precondition: cursor is not tail
    // postcondition: cursor was set to next item
    abstract fun right()

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
    abstract fun clear()

    // postcondition: tail was set to new added item
    abstract fun addTail(item: T)

    // precondition: linked list is not empty
    // postcondition: cursor item replaced by new added item
    abstract fun replace(item: T)

    // precondition: item exist to the right of cursor
    // postcondition: cursor was set to the item
    abstract fun find(item: T)

    // postcondition: all items which equal to argument item were deleted
    abstract fun removeAll(item: T)


    // precondition: linked list is not empty
    abstract fun get(): T

    abstract fun size(): Int

    abstract fun isHead(): Boolean

    abstract fun isTail(): Boolean

    abstract fun isValue(): Boolean

    abstract fun getHeadStatus(): Int

    abstract fun getTailStatus(): Int

    abstract fun getRightStatus(): Int

    abstract fun getPutRightStatus(): Int

    abstract fun getPutLeftStatus(): Int

    abstract fun getRemoveStatus(): Int

    abstract fun getReplaceStatus(): Int

    abstract fun getFindStatus(): Int
}
