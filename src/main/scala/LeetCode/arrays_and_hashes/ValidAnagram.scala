package LeetCode.arrays_and_hashes

import scala.collection.mutable.Map

object ValidAnagram extends App {
  def isAnagram(s:String, t:String): Boolean = {
    if (s.length == t.length) {
      var charMap = Map[Char, Int]()

      for (c <- s) {
        if (charMap.contains(c)) charMap(c) = charMap(c) + 1
        else charMap += (c -> 1)
      }

      for (c <- t) {
        if (charMap.contains(c)) charMap(c) = charMap(c) - 1
        else charMap += (c -> 1)
      }

      for ((_,v) <- charMap) {
        if (v != 0) return false
      }

      true

    } else {
      false
    }

  }

  println(isAnagram("anagram", "nagaram"))
}
