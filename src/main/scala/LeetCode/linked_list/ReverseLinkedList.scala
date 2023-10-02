package LeetCode.linked_list

object ReverseLinkedList extends App {
  def mkNode[T](i: T, next: ListNode[T]): ListNode[T] = {
    new ListNode[T](i, next)
  }

  def createLinkedList(n: Int): ListNode[Int] = {
    if (n <= 0 ) throw new Exception("List has to be a positive Integer")
    else if (n == 1) mkNode(0, null)
    else {
      var current = mkNode(0, null)
      var nextNode = mkNode(1, null)
      current.next = nextNode
      val begin = current
      for (i <- 3 to n) {
        current = current.next
        nextNode = mkNode(i, null)
        current.next = nextNode
      }
      begin
    }
  }

  def createLinkedListRecursive(n :Int): ListNode[Int] = {
    def _createList(i: Int, node: ListNode[Int]): Unit = {
      if (i < n) {
        val newNode = mkNode[Int](i, null)
        node.next = newNode
        _createList(i + 1, newNode)
      }
    }
    val first = mkNode[Int](0, null)
    if (n > 0 ) {
      _createList(1, first)
    } else throw new Exception("List has to be a positive Integer")

    first
  }

  def reverseLinkedList[T](input: LinkedList[T]): Unit = {
    var curr = input.head
    var temp = curr.next
    curr.next = null
    var prev = curr
    curr = temp
    input.last = prev

    while (curr != null) {
      temp = curr.next
      curr.next = prev
      prev = curr
      curr = temp
    }
    input.head = prev
  }

  val list = createLinkedListRecursive(20)
  var node = list
  while (node != null) {
    println(node.x)
    node = node.next
  }

  println("----------------")

  val newList = new LinkedList[Int]()
  newList.add(4)
  newList.add(2)
  newList.add(3)
  newList.add(1)
  newList.add(8)

  reverseLinkedList[Int](newList)
  node = newList.head
  while (node != null) {
    println(node.x)
    node = node.next
  }
}
