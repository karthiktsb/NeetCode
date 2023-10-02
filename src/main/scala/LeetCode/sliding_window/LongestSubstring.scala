package LeetCode.sliding_window

import scala.collection.mutable.HashSet;

object LongestSubstring extends App {
  def longestSubstring(s:String): Int = {
    var maxLength = 0
    var left = 0
    var right = 0
    var seen:HashSet[Char] = HashSet()

    while (right < s.length) {
      if (!seen.contains(s(right))) {
        seen.add(s(right))
        maxLength = Math.max(maxLength, right - left + 1)
        right += 1
      } else {
        seen.remove(s(left))
        left += 1
      }
    }
    maxLength

  }

  println(longestSubstring("abacdaefb"))
}
