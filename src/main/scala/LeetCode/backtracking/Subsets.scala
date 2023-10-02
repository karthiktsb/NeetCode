package LeetCode.backtracking

object Subsets extends App {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    def backtrack(start: Int, path: List[Int]): List[List[Int]] = {
      if (start >= nums.length) {
        List(path)
      } else {
        val includeList = backtrack(start + 1, path :+ nums(start))
        val excludeList = backtrack(start + 1, path)

        includeList ::: excludeList
      }
    }

    backtrack(0, Nil)
  }

  val nums = Array(1, 2, 3)
  val result = subsets(nums)
  result.foreach(subset => println(subset.mkString("[", ", ", "]")))

}

