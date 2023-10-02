package LeetCode.backtracking

object CombinationSum2 extends App {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val sorted = candidates.sorted

    def backtrack(start: Int, currentSum: Int, path: List[Int]): List[List[Int]] = {
      if (currentSum == target) {
        List(path)
      } else if (currentSum > target || start >= candidates.length) {
        Nil
      } else {

        val sumCurrent = backtrack(start + 1, currentSum + sorted(start), sorted(start) :: path)
        var next = start + 1
        while (next < candidates.length - 1 && sorted(next) == sorted(start)) {
          next += 1
        }
        val moveToNext = backtrack(next, currentSum, path)

        sumCurrent ::: moveToNext
      }
    }

    backtrack(0, 0, Nil)
  }

  val candidates = Array(10,1,2,7,6,1,5)
  val target = 8
  val result = combinationSum(candidates, target)
  result.foreach(combination => println(combination.mkString("[", ", ", "]")))

  println("-----------------")

  val candidates1 = Array(2,5,2,1,2)
  val target1 = 5
  val result1 = combinationSum(candidates1, target1)
  result1.foreach(combination => println(combination.mkString("[", ", ", "]")))
}
