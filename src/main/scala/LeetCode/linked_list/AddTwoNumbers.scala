package LeetCode.linked_list

object AddTwoNumbers extends App {
  def addTwoNumbers(l1: ListNode[Int], l2: ListNode[Int]): ListNode[Int] = {

    def _addTwoNums(c1: ListNode[Int], c2: ListNode[Int], carry: Int): (ListNode[Int], Int) = {
      if (c1 == null && c2 == null) {
        if (carry == 0)  (null, 0)
        else (new ListNode[Int](carry, null), 0)
      } else if (c1 != null && c2 == null) {
        val sum = c1.x + carry
        if (sum >= 10) {
          (new ListNode[Int](sum % 10, null), sum / 10)
        } else {
          (new ListNode[Int](sum, null), 0)
        }
      } else if (c1 == null && c2 != null) {
        val sum = c2.x + carry
        if (sum >= 10) {
          (new ListNode[Int](sum % 10, null), sum / 10)
        } else {
          (new ListNode[Int](sum, null), 0)
        }
      } else {
        val sum = c1.x + c2.x + carry
        if (sum >= 10) {
          (new ListNode[Int](sum % 10, null), sum / 10)
        } else {
          (new ListNode[Int](sum, null), 0)
        }
      }
    }

    var (curr, carry) = _addTwoNums(l1, l2, 0)
    val head = curr
    var temp1 = l1.next
    var temp2 = l2.next
    while (curr != null) {
      var (temp3, tempCarry) = _addTwoNums(temp1, temp2, carry)
      curr.next = temp3
      curr = temp3
      carry = tempCarry
      if (temp1 != null ) temp1 = temp1.next
      if (temp2 != null) temp2 = temp2.next
    }
    if (carry > 0) {
      curr.next = new ListNode[Int](carry, null)
    }

    head
    }


  val head1 = new ListNode[Int](9, null)
  val tail1 = new ListNode[Int](9, null)
  val tail12 = new ListNode[Int](9, null)
  val tail13 = new ListNode[Int](9, null)
  val tail14 = new ListNode[Int](9, null)
  val tail15 = new ListNode[Int](9, null)
  val tail16 = new ListNode[Int](9, null)

  val head2 = new ListNode[Int](9, null)
  val tail2 = new ListNode[Int](9, null)
  val tail21 = new ListNode[Int](9, null)
  val tail22 = new ListNode[Int](9, null)

  head1.next = tail1
  tail1.next = tail12
  tail12.next = tail13
  tail13.next = tail14
  tail14.next = tail15
  tail15.next = tail16

  head2.next = tail2
  tail2.next = tail21
  tail21.next = tail22

  var curr = head1
  while (curr != null) {
    println(curr.x)
    curr = curr.next
  }

  println("---------------------")
  curr = head2
  while (curr != null) {
    println(curr.x)
    curr = curr.next
  }

  println("---------------------")
  val head3 = addTwoNumbers(head1, head2)

  curr = head3
  while(curr != null) {
    println(curr.x)
    curr = curr.next
  }

}
