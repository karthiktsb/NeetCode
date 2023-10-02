package LeetCode.dynamic_programming

import scala.util.control.Breaks.break

object WordBreak extends App {
  def wordBreakDp(s: String, wordDict: List[String]): Boolean = {
    var dp = Array.fill(s.length + 1)(false)
    dp(s.length) = true

    for (i <- s.length -1 to 0 by -1) {
      var j = 0
      while (dp(i) == false && j < wordDict.length) {
        val w = wordDict(j)
        if (i + w.length <= s.length) {
          if (s.substring(i, i + w.length) == w)
            dp(i) = dp(i + w.length)
        }
        j += 1
      }
    }
    println(dp.toList)

    dp(0)
  }

  def wordBreakBt(s: String, wordDict: List[String]): List[List[String]] = {
    def _workBreak(i: Int, path: List[String]): List[List[String]] = {
      if (i >= s.length) {
        List(path)
      } else {
        (for {
          w <- wordDict
          if (i + w.length <= s.length && s.substring(i, i + w.length) == w)
          output <- _workBreak(i + w.length, path :+ w)
        } yield output).toList
      }
    }

    _workBreak(0, Nil)
  }

  println(wordBreakDp("leetscode", List("leet", "code")))
  println(wordBreakDp("catsand", List("cat", "cats", "sand", "and")))
  println(wordBreakBt("leetcode", List("leet", "code")))
  println(wordBreakBt("catsand", List("cat", "cats", "sand", "and")))
}
