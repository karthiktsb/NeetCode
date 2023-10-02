package LeetCode.dynamic_programming

object CoinChange extends App {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    var dp = Array.fill(amount + 1)(amount + 1)
    dp(0) = 0

    for (a <- 1 to amount) {
      var i = 0
      while(i < coins.length && a - coins(i) >= 0) {
        dp(a) = Math.min(dp(a), 1 + dp(a - coins(i)))
        i += 1
      }
    }

    if (dp(amount) <= amount) dp(amount) else -1
  }

  println(coinChange(Array(1,5,9), 11))
  println(coinChange(Array(1,3,7), 10))
  println(coinChange(Array(2), 3))
  println(coinChange(Array(2), 0))
  println(coinChange(Array(1,2,3), 100))
}
