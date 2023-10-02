package LeetCode.stack

import scala.collection.mutable.Stack

object ValidParanthesis extends App {
  def validParanthesis(s: String): Boolean = {
    var stack: Stack[Int] = Stack()
    var hold: Map[Char, Char] = Map('}' -> '{', ']' -> '[', ')' -> '(')

    for (i <- s) {
      if (hold.contains(i)) {
        var elem = if (stack.nonEmpty) stack.pop() else '#'
        if (hold(i) != elem) return false
      } else
        stack.push(i)
    }

    true
  }

  println(validParanthesis("()"))
  println(validParanthesis("(){}[]"))
  println(validParanthesis("[{()}]"))
  println(validParanthesis("[{()]}"))
}
