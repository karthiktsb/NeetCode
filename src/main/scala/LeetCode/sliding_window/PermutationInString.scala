package LeetCode.sliding_window

object PermutationInString extends App {
  def checkInclusionClassicKarthik(s1: String, s2: String): Boolean = {
    if (s1.length > 0 & s2.length > 0) {
      val s1Sorted = s1.sorted
      val s2Perm = s2.sliding(s1.length).filter(x => x.sorted == s1Sorted)

      if (s2Perm.hasNext) true
      else false
    } else false
  }

  def checkInclusion(s1: String, s2: String): Boolean = {
    if (s1.length > 0 & s2.length > 0) {
      val s1Sort = s1.sorted
      val len = s1.length
      var i = 0
      var found = false
      while (i + len <= s2.length && !found) {
        println(s2.substring(i, i + len))
        if (s2.substring(i, i + len).sorted == s1Sort) found = true
        i += 1
      }
      found
    } else false
  }

  println(checkInclusion("ab", "skfjhkhadljlaskjdbsdhklkjdf"))
  println(checkInclusion("adc", "dcda"))
}
