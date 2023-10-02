package LeetCode.linked_list

object Cyclic extends App {
  def hasCycle(head: ListNode[Int]): Boolean = {
    if (head == null) false
    var (slow, fast) = (head, head)

    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next

      if (slow == fast) return true
    }

    false
  }

  val head = new ListNode[Int](0, null)
  val t1 = new ListNode[Int](1, null)
  val t2 = new ListNode[Int](2, null)
  val t3 = new ListNode[Int](3, null)
  head.next = t1
  t1.next = t2
  t2.next = head

  println(hasCycle(head))
  val head1: ListNode[Int] = null
  println(hasCycle(head1))

}
