package LeetCode.backtracking

object PalindromePartitioning extends App {
  def partition(s: String): List[List[String]] = {
    var result: List[List[String]] = List.empty
    def backTrack(start: Int, path: List[String]): Unit = {
      if (start >= s.length) {
        result = result.appended(path)
      }
      for (i <- start + 1 to s.length) {
        if (s.substring(start, i) == s.substring(start, i).reverse) {
          backTrack(i, path :+ s.substring(start, i))
        }
      }
    }
    backTrack(0, List.empty)
    result
  }

  def partition1(s: String): List[List[String]] = {
    def backTrack(start: Int, path: List[String]): List[List[String]] = {
      if (start >= s.length) {
        List(path)
      } else {
        (for {
          i <- start + 1 to s.length
          if (s.substring(start, i) == s.substring(start, i).reverse)
          newCombination <- backTrack(i, path :+ s.substring(start, i))
        } yield newCombination).toList
      }
    }
    backTrack(0, List.empty)
  }

  println(partition("aab"))
  println(partition1("ababa"))
}

