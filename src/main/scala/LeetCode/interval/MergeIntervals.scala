package LeetCode.interval

object MergeIntervals extends App {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    val intervalSorted = intervals.sortWith(_.head < _.head)
    def _checkIntervals(a: Array[Int], b: Array[Int]): Array[Array[Int]] = {
      if (a(0) >= b(0)) {
        if (a(0) <= b(1)) {
          Array(Array(b(0), Math.max(a(1), b(1))))
        } else {
          Array(b, a)
        }
      } else {
        if (a(1) < b(0)) Array(a, b)
        else Array(Array(a(0), Math.max(a(1), b(1))))
      }
    }

    def _merge(path: Array[Array[Int]], i: Int): Array[Array[Int]] = {
      if (i >= intervals.length) path
      else {
        _merge(path.init ++ _checkIntervals(intervals(i), path.last) , i + 1)
      }
    }

    if (intervals.length > 1) _merge(Array(intervalSorted.head), 1) else intervals
  }

  println(merge(Array(Array(1,3),Array(2,6),Array(8,10),Array(15,18))).map(_.toList).toList)
  println(merge(Array(Array(1,4),Array(4,5))).map(_.toList).toList)
  println(merge(Array(Array(2,3),Array(4,5),Array(6,7),Array(8,9), Array(1,10))).map(_.toList).toList)
}
