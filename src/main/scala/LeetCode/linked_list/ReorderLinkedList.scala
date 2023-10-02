package LeetCode.linked_list

object ReorderLinkedList extends App {
  def reorder(node: ListNode[Int]): Unit = {
    var (slow, fast) = (node, node)
    while(fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }

    var curr = slow
    var prev: ListNode[Int] = null
    var temp = curr.next
    while(curr != null) {
      temp = curr.next
      curr.next = prev
      prev = curr
      curr = temp
    }

    var first = node
    var second = prev
    while (second.next != null) {
      val temp1 = first.next
      val temp2 = second.next
      first.next = second
      second.next = temp1
      first = temp1
      second = temp2
    }
  }

  val head = new ListNode[Int](0, null)
  val l1 = new ListNode[Int](1, null)
  val l2 = new ListNode[Int](10, null)
  val l3 = new ListNode[Int](12, null)
  val l4 = new ListNode[Int](16, null)
  val l5 = new ListNode[Int](17, null)
  head.next = l1
  l1.next = l2
  l2.next = l3
  l3.next = l4
  l4.next = l5

  var curr = head
  while (curr != null) {
    println(curr.x)
    curr = curr.next
  }
  println("_______________________")
  reorder(head)

  curr = head
  println("_______________________")
  println("_______________________")
  println("_______________________")
  while (curr != null) {
    println(curr.x)
    curr = curr.next
  }
}
