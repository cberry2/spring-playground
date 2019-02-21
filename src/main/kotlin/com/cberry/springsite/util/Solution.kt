package com.cberry.springsite.util

fun main(args:Array<String>) {
    val arr = twoSum(listOf(0, 4, 3, 0).toIntArray(), 0).toString()
    arr.forEach { println(it) }
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val complementMap = nums
            .filter { target - it > -1 }
            .mapIndexed { i, num -> target - num to i }
            .toMap()

    nums.forEachIndexed { i, num ->
        if (complementMap.containsKey(num))
            return listOf(i, nums.lastIndexOf(target - num)).toIntArray()
    }
    throw Exception("something went wrong")
}
fun twoSu2m(nums: IntArray, target: Int): IntArray {
    val complementMap = nums.filter { target - it > -1 }.associate { target - it to  target }
    nums.forEachIndexed { i, num ->
        if (complementMap.containsKey(num))
            return listOf(i, nums.indexOf(target - num)).toIntArray()
    }
    throw Exception("something went wrong")
}

//class ListNode(var `val`: Int = 0) {
//    var next: ListNode? = null
//}

//fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
//
//    return getListNode(123)
//}
//
//fun getListNode(i: Int): ListNode? {
//    val reverseStr = i.toString().reversed()
//    var listNode = ListNode()
//    reverseStr.forEach {
//        listNode.next
//    }
//
//
//}

data class ListNode(
    val data: Int,
    var next: ListNode
)

fun insertNodeAtPosition(head: ListNode?, data: Int, position: Int): ListNode? {
    if (head == null || position < 0) throw RuntimeException()

    if (position == 0) {
        return ListNode(data, head)
    }

    head.next = insertNodeAtPosition(head.next, data, position - 1)!!

    return head
}

