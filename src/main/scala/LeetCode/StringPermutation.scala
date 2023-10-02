package LeetCode

object StringPermutation extends App {
  def checkInclusion(s1: String, s2: String): Boolean = {
    if (s1.length > 0 & s2.length > 0) {
      val s1Sorted = s1.sorted
      println(s1Sorted)
      val s2Perm = s2.sliding(s1.length).filter(x => x.sorted == s1Sorted)

      if (s2Perm.hasNext) true
      else false
    } else false
  }

  println(checkInclusion("ab", "eidbaooo"))
}
