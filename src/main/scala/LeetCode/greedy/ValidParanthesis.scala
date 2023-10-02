package LeetCode.greedy

object ValidParanthesis extends App {
  def checkValidString(s: String): Boolean = {
    var (leftMin, leftMax, i) = (0,0, 0)

    while (i < s.length && leftMax >= 0) {
        if (s(i).equals('(')) {
          leftMin += 1
          leftMax += 1
        } else if (s(i).equals(')')) {
          leftMin -= 1
          leftMax -= 1
        } else {
          leftMin -= 1
          leftMax += 1
        }
      if (leftMin < 0) leftMin = 0
      i += 1
    }

    if (leftMax < 0) false else leftMin == 0
  }


  println(checkValidString("(*()"))
}

