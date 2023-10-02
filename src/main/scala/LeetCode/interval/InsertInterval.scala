package LeetCode.interval

object InsertInterval extends App {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
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

    def _insert(path: Array[Array[Int]], i:Int): Array[Array[Int]] = {
      if (i >= intervals.length) path
      else _insert(path.init ++ _checkIntervals(intervals(i), path.last), i + 1)
    }
    _insert(Array(newInterval), 0)
  }

  println(insert(Array(Array(2,8), Array(10,20)), Array(25,39)).map(_.toList).toList)
}
