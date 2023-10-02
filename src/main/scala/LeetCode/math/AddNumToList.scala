package LeetCode.math

import scala.util.control.Breaks.break

object AddNumToList extends App {
  def AddOne(a:Array[Int]): Array[Int] = {
    def _addOne(i: Int, num: Int): Array[Int] = {
      if (i >= 0) {
        if (num > 0) {
          if ((a(i) + num) > 9) _addOne(i - 1, 1) :+ 0
          else _addOne(i - 1, 0) :+ (a(i) + num)
        } else {
          a.slice(0, i + 1)
        }
      } else {
        if (num > 0) Array(1)
        else Array()
      }
    }

    if (a.length > 0) _addOne(a.length -1, 1) else Array()
  }

  println(AddOne(Array(9,9,9,9)).toList)
}
