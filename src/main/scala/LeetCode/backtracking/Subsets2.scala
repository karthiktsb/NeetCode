package LeetCode.backtracking

object Subsets2 extends App {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val sortedNums = nums.sorted
    def backtrack(start: Int, path: List[Int]): List[List[Int]] = {
      if (start >= nums.length) {
        List(path)
      } else {
        val includeList = backtrack(start + 1, sortedNums(start) :: path)
        var next = start + 1
        while (next <= sortedNums.length - 1 && sortedNums(next) == sortedNums(start)) {
          next += 1
        }

        val excludeList = backtrack(next, path)

        includeList ::: excludeList
      }
    }

    backtrack(0, Nil)
  }

  val nums = Array(1,1)
  val result = subsets(nums)
  println(result)

}
