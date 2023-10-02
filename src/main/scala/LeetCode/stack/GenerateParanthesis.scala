package LeetCode.stack

object GenerateParanthesis extends App {
  def generateParanthesis(n: Int): List[String] = {
    def backTrack(current: String, openCount: Int, closeCount: Int): List[String] = {
      if (current.length == 2 * n) {
        return List(current)
      } else {
        var result: List[String] = List.empty

        if (openCount < n)
          result = result ::: backTrack(current + '(', openCount + 1, closeCount)

        if (closeCount < openCount)
          result = result ::: backTrack(current + ')', openCount, closeCount + 1)

        result
      }
    }

    backTrack("", 0, 0)
  }

  println(generateParanthesis(3))
}
