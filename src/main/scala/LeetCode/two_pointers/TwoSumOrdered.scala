package LeetCode.two_pointers

import scala.collection.mutable.Map

object TwoSumOrdered extends App {
  def twoSumWithHash(numbers: Array[Int], target: Int): Option[List[Int]] = {
    var hold = Map[Int, Int]()

    for (i <- 0 until numbers.length) {
      val answer = hold.get(target - numbers(i)).map(x => List(x,i + 1))

      if (answer.isEmpty)
        hold.put(numbers(i), i + 1)
      else
        return answer
    }

    None
  }

  def twoSumTwoPointer(numbers: Array[Int], target: Int): Array[Int] = {
     var (left, right) = (0, numbers.length - 1)

    while (left < right) {
      val sum = numbers(left) + numbers(right)

      if (sum == target) {
        return Array(left + 1, right + 1)
      } else {
        if (sum < target)
          left += 1
        else
          right -= 1
      }
    }

    Array(-1, -1)
  }

  println(twoSumWithHash(Array(2,7,11,15),9))
  println(twoSumTwoPointer(Array(2,7,11,15),27).toList)
}
