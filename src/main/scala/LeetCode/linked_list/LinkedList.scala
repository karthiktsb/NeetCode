package LeetCode.linked_list

class ListNode[T](val x: T, var next: ListNode[T])

class LinkedList[T]() {
  var head: ListNode[T] = null
  var last: ListNode[T] = null
  var count = 0

  def add(in: T): Unit = {
    val newNode = new ListNode[T](in, null)
    if (head == null) {
      head = newNode
      last = head
    } else {
      if (last == null) {
        last = newNode
        head.next = last
      } else {
        last.next = newNode
        last = newNode
      }
    }
    count += 1
  }

  def printList(): Unit = {
    var curr = head
    while (curr != null) {
      println(curr.x)
      curr = curr.next
    }
  }

  def printListBackwards(node: ListNode[T]): Unit = {
    if (node != null) {
      printListBackwards(node.next)
      println(node.x)
    }
  }

  def listBackwards(node: ListNode[T]): List[ListNode[T]] = {
    if (node != null) listBackwards(node.next) :+ node
    else Nil
  }

  def findInList(in:T): Int = {
    var curr = head
    var index = 0
    while (curr != null && curr.x != in) {
      println(curr.x)
      curr = curr.next
      index += 1
    }
    if (curr == null) -1 else index
  }

  def reverse(): Unit = {
    var curr = head
    var temp = curr.next
    curr.next = null
    var prev = curr
    curr = temp
    last = prev

    while (curr != null) {
      temp = curr.next
      curr.next = prev
      prev = curr
      curr = temp
    }
    head = prev
  }
}

object LinkedList extends App {

  val newList = new LinkedList[Int]()
  newList.add(4)
  newList.add(2)
  newList.add(3)
  newList.add(1)
  newList.add(8)
  newList.printList()
  println(newList.findInList(9))

  val newListStr = new LinkedList[String]()
  newListStr.add("abc")
  newListStr.add("def")
  newListStr.add("hij")
  newListStr.add("KLM")
  newListStr.add("SF")
  newListStr.printList()
  println("--------------")
  println(newListStr.findInList("KlM"))
  newListStr.reverse()
  println("--------------")
  println(newListStr.printList())
  println(newListStr.count)
}