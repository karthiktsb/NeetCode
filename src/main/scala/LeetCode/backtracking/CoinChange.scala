package LeetCode.backtracking

object CoinChange extends App {
  def leastCoins(coins: Array[Int], target: Int): Int = {
    val sorted = coins.sorted
    var result = Int.MaxValue

    def backtrack(start: Int, currentSum: Int, path: List[Int]): Unit = {
      if (currentSum == target) {
        if (path.length < result) result = path.length
      } else if (currentSum > target || start >= coins.length) {
        Nil
      } else {
        backtrack(start, currentSum + sorted(start), sorted(start) :: path)
        backtrack(start + 1, currentSum, path)
      }
    }

    backtrack(0, 0, Nil)

    if (result == Int.MaxValue) -1
    else result
  }

  println(leastCoins(Array(1,2,5), 11))
  println(leastCoins(Array(3,7,405,436), 8839))
}
