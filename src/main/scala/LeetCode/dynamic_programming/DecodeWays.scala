package LeetCode.dynamic_programming

object DecodeWays extends App {
  def numDecodings(s: String): Int = {
    var (next, nextTwo) = (0,1)
    if (s(s.length - 1) != '0') {
      next = 1
    }

    for (i <- s.length - 2 to 0 by -1) {
      val tmp = next
      val curr = s.substring(i, i + 2).toInt
      if (s(i) != '0') {
        if (curr >= 10 && curr <= 26)  next = next + nextTwo
      } else {
        next = 0
      }
      nextTwo = tmp
    }

    next
  }

  println(numDecodings("127"))
}
