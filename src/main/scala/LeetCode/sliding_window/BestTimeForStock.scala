package LeetCode.sliding_window

object BestTimeForStock extends App {
  def maxProfit(prices: Array[Int]): Int = {
    var maxProfit = 0
    var minPrice = prices(0)
    var currentProfit = 0

    for (i <- prices) {
      currentProfit = i - minPrice
      minPrice = Math.min(minPrice, i)
      maxProfit = Math.max(maxProfit, currentProfit)
    }

    maxProfit
  }

  println(maxProfit(Array(7,1,5,3,6,4)))
}
