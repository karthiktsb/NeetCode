package LeetCode.binary_search

object FindInsertIndex extends App {
  def findInsertIndex(l: List[Int], v:Int): Int = {
    var left = 0
    var right = l.length - 1

    while (left < right) {
      val mid = left + ((right - left)/2)

      if (v >= l(mid)) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }

    if (left == l.length - 1  && v > l(left)) left + 1 else left
  }

  println(findInsertIndex(List(1,3,5,7,18), 0))
}
