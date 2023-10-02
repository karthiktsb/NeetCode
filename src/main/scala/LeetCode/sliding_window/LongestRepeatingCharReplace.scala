package LeetCode.sliding_window

import scala.collection.mutable.Map

object LongestRepeatingCharReplace extends App {
  def characterReplacement(s: String, k: Int): Int = {
    val lkp = Map[Char, Int]()
    var (res, l) = (0,0)
    var maxV = 0

    for (r <- 0 until s.length) {
      if (lkp.contains(s(r))) lkp(s(r)) = lkp(s(r)) + 1
      else lkp.addOne(s(r), 1)

      maxV = Math.max(maxV, lkp(s(r)))

      while ((r - l + 1) - maxV > k) {
        lkp(s(l)) = lkp(s(l)) - 1
        l += 1
      }

      res = Math.max(res, r - l + 1)
      println(lkp)
    }

    res
  }

  println(characterReplacement("AABABBA", 1))
}
