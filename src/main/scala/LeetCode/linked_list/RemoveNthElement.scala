package LeetCode.linked_list

object RemoveNthElement extends App {
  def removeNthFromEnd(head: ListNode[Int], n: Int): ListNode[Int] = {
    val dummy = new ListNode[Int](0, null)
    dummy.next = head

    var (first, second) = (dummy, dummy)
    var count = 0
    for (_ <- 0 to n ) {
      if (second != null) {
        second = second.next
        count += 1
      }
    }

    if (count != n + 1 ) {
      throw new Exception("n is greater than the size of the Linked List")
    }

    while (second != null){
      second = second.next
      first = first.next
    }

    first.next = first.next.next

    dummy.next
  }

  var head = new ListNode[Int](0, null)
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

  head = removeNthFromEnd(head, 6)

  var curr = head
  while (curr != null) {
    println(curr.x)
    curr = curr.next
  }
}
