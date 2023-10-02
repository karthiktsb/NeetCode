package LeetCode.backtracking

object PhoneNumber extends App {
  def letterCombinations(digits: String): List[String] = {
    var result:List[String] = List.empty
    val lkp = Map('2' -> "abc", '3' -> "def", '4' -> "ghi")
    def backTract(start: Int, current: String): Unit = {
      if (start >= digits.length) {
        result = result.appended(current)
      } else {
        val curLkp = lkp(digits.charAt(start))
        for (i <- 0 until curLkp.length) {
          backTract(start + 1, current + curLkp(i).toString)
        }
      }
    }
    backTract(0, "")
    result
  }

  def letterCombinations1(digits: String): List[String] = {
    val lkp = Map('2' -> "abc", '3' -> "def", '4' -> "ghi", '5' -> "jkl", '6' -> "mno", '7' -> "pqrs", '8' -> "tuv", '9' -> "wxyz")

    def backTract(start: Int, current: String): List[String] = {
      if (start >= digits.length) {
        if (current.length > 0) List(current)
        else List.empty
      } else {
        val curLkp = lkp(digits.charAt(start))
        val combinations = for {
          i <- 0 until curLkp.length
          newCombination <- backTract(start + 1, current + curLkp(i).toString)
        } yield newCombination
        combinations.toList
      }
    }

    backTract(0, "")
  }

  println(letterCombinations("234"))
  println(letterCombinations1("234"))
}
