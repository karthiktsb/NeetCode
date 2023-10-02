package LeetCode.dynamic_programming

object ClimbSteps extends App {
  def climbStairs(n: Int): Int = {
    var one = 1
    var two = 1
    var temp = 0
    for (i <- 0 until n - 1) {
      temp = one
      one = one + two
      two = temp
    }
    one
  }

  println(climbStairs(5))
}
