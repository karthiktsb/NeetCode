package LeetCode.dynamic_programming

object getPalindomeSubstrings extends App {
  def countSubstrings(s:String): Int = {
    def checkForPalindome(left: Int, right: Int): List[String] = {
      if (left >= 0 && right < s.length && s.charAt(left).equals(s.charAt(right))) {
        List(s.substring(left, right + 1)) ::: checkForPalindome(left - 1, right + 1)
      } else {
        Nil
      }
    }

    (for {
      i <- 0 until s.length
      result <- checkForPalindome(i, i) ::: checkForPalindome(i, i + 1)
    } yield result).toList.length
  }

  println(countSubstrings("aba"))
}
