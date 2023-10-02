package LeetCode.greedy

object MaxSubArray extends App {
  def maxSubArray(nums: Array[Int]): Int ={
    var result = nums(0)
    var total = 0

    for (n <- nums) {
      total += n
      result = Math.max(result, total)
      if (total < 0) total = 0
    }

    result
  }

  def maxSubArrayList(nums: Array[Int]): Int = {
    def maxSum(i: Int): Int = {
      if (i == 0) Int.MinValue
      else Math.max(nums.sliding(i).map(_.sum).max, maxSum(i - 1))
    }

    maxSum(nums.length)
  }

  println(maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)))
  println(maxSubArrayList(Array(-2,1,-3,4,-1,2,1,-5,4)))

}
