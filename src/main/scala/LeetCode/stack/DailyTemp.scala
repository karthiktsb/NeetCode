package LeetCode.stack

import scala.collection.mutable.Stack

object DailyTemp extends App {
  def dailyTemp(in: Array[Int]): Array[Int] = {
    var out = Array.fill(in.length)(0)
    var st: Stack[Int] = Stack()

    for (i <- in.indices) {
      while (st.nonEmpty && in(i) > in(st.top)) {
        var prevIndex = st.pop()
        out(prevIndex) = i - prevIndex
      }
      st.push(i)
    }

    out
  }

  println(dailyTemp(Array(73,74,70,71,69,72,76,73)).toList)
}
