package LeetCode

object ProductOfArray extends App {
  def product(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val result = Array.ofDim[Int](n)

    result(0) = 1

    for (i <- 1 until n) {
      result(i) = nums(i -1) * result(i - 1)
    }

    var prevProduct = 1
    for (i <- n - 1 to 0 by -1) {
      result(i) *= prevProduct
      prevProduct *= nums(i)
    }

    result
  }

  println(product(Array(1,2,3,4)).toList)
}
