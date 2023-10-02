package LeetCode.backtracking

object CombinationSum extends App {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val sorted = candidates.sorted
    def backtrack(start: Int, currentSum: Int, path: List[Int]): List[List[Int]] = {
      if (currentSum == target) {
        List(path)
      } else if (currentSum > target || start >= candidates.length) {
        Nil
      } else {
        val sameNumList = backtrack(start, currentSum + sorted(start), sorted(start) :: path)
        val nextNumList = backtrack(start + 1, currentSum, path)

        sameNumList ::: nextNumList
      }
    }

    backtrack(0, 0, Nil)
  }

  val candidates = Array(2, 3, 6, 7)
  val target = 6
  val result = combinationSum(candidates, target)
  result.foreach(combination => println(combination.mkString("[", ", ", "]")))

}
