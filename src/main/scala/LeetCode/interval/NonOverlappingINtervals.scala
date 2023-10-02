package LeetCode.interval

object NonOverlappingINtervals extends App {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    val intervalSorted = intervals.sortWith(_.head < _.head)
    var result = 0
    var prevEnd = intervals(0)(1)

    for (i <- 1 until intervals.length) {
      val (start, end) = (intervalSorted(i)(0), intervalSorted(i)(1))
      if (start >= prevEnd) {
        prevEnd = end
      } else {
        result += 1
        prevEnd = Math.min(prevEnd, end)
      }
    }

    result
  }

  println(eraseOverlapIntervals(Array(Array(1,2), Array(2,3), Array(3,4), Array(1,3))))
}
