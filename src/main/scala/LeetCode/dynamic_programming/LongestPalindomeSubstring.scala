package LeetCode.dynamic_programming

object LongestPalindomeSubstring extends App {
  def longestPalindrome(s: String): String = {
    var result = ""

    def getLongestPalimdrome(left: Int, right: Int): Unit = {
      var l = left
      var r = right
      while (l >= 0 && r < s.length && s.charAt(l).equals(s.charAt(r))) {
        if ((r - l + 1) > result.length) {
          result = s.substring(l, r + 1)
        }
        l -= 1
        r += 1
      }
    }

    def getLongestPalimdrome1(left: Int, right: Int, max: String): String = {
      if (left >= 0 && right < s.length && s.charAt(left).equals(s.charAt(right))) {
        if ((right - left + 1) > max.length) getLongestPalimdrome1(left - 1, right + 1, s.substring(left,right + 1))
        else getLongestPalimdrome1(left - 1, right + 1, max)
      } else {
        max
      }
    }

    for (i <- 0 until s.length) {
      val currentMaxOdd = getLongestPalimdrome1(i, i, result)
      if (currentMaxOdd.length > result.length) result = currentMaxOdd
      val currentMaxEven = getLongestPalimdrome1(i, i + 1, result)
      if (currentMaxEven.length > result.length) result = currentMaxEven
    }

    result
  }

  println(longestPalindrome("abcddcbd"))
  val a = Array(9,8,7,6,5,4,3,2,1,0)
  val added = a.map(_.toString).mkString("").toLong + 1
  println(added.toString.split("").map(_.toInt).toList)
}
