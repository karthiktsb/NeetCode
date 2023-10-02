package LeetCode.linked_list

object MergeSortedLists extends App {
  val list1 = new LinkedList[Int]()
  list1.add(1)
  list1.add(3)
  list1.add(5)
  list1.add(7)
  list1.add(9)

  val list2 = new LinkedList[Int]()
  list2.add(2)
  list2.add(4)
  list2.add(6)
  list2.add(8)
  list2.add(10)

  def mergeLists(l1: LinkedList[Int], l2: LinkedList[Int]): LinkedList[Int] = {
    val result = new LinkedList[Int]
    var curr1 =  l1.head
    var curr2 =  l2.head
    result.head = if (curr1.x < curr2.x) {
      var temp = curr1
      curr1 = curr1.next
      temp
    } else {
      var temp = curr2
      curr2 = curr2.next
      curr2
    }

    while (curr1 != null || curr2 != null) {
      if (curr1 != null && curr2 != null) {
        if (curr1.x < curr2.x) {
          result.add(curr1.x)
          curr1 = curr1.next
        } else {
          result.add(curr2.x)
          curr2 = curr2.next
        }
      } else if (curr1 != null) {
        result.add(curr1.x)
        curr1 = curr1.next
      } else {
        result.add(curr2.x)
        curr2 = curr2.next
      }
    }

    result
  }

  val mergedList = mergeLists(list1, list2)
  mergedList.printList()
  println("-------------")
  mergedList.printListBackwards(mergedList.head)
  println(mergedList.listBackwards(mergedList.head).map(_.x))
}
