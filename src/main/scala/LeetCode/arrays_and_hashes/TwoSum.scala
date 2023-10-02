package LeetCode.arrays_and_hashes

import scala.collection.mutable.Map

object TwoSum extends App {
  def twoSum(nums: Array[Int], target: Int): List[Int] = {
    var result: List[Int] = List()

    for (i <- 0 until nums.length - 1) {
      for ( j <- i + 1 until nums.length) {
        if (nums(i) + nums(j) == target) {
          result = result ++ List(i,j)
          return result
        }
      }
    }
    List()
  }

  def twoSumOnePass(nums: Array[Int], target: Int): Array[Int] = {
    val targets = Map[Int, Int]()

    for ((v, i) <- nums.zipWithIndex) {
      val answer = targets.get(target - v).map(Array(_, i))

      if (answer.nonEmpty)
        return answer.get

      targets += (v -> i)
    }

    Array()
  }

  println(twoSum(Array(11,15,11,33,22,44,56,677,55,43,33,33,33,3,6), 9).toList)
  println(twoSumOnePass(Array(11,15,11,33,22,44,56,677,55,43,33,33,33,3,6), 9).toList)
  println(twoSumOnePass(Array(1,3), 5).toList)
}
