package LeetCode.stack

import scala.collection.mutable.Stack

object LargestRectangleArea extends App {
  def largestRectangleArea(heights: Array[Int]): Int = {
    var stack: Stack[Int] = Stack()
    var maxArea = 0

    for (i <- heights.indices) {
      while (stack.nonEmpty && heights(i) < heights(stack.top)) {
        var height = heights(stack.pop())
        var width = if (stack.isEmpty) i else i - stack.top - 1
        maxArea = maxArea.max(height * width)
      }
      stack.push(i)
    }

    while (stack.nonEmpty) {
      var height = heights(stack.pop())
      var width = if (stack.isEmpty) heights.length else heights.length - stack.top - 1
      maxArea = maxArea.max(height * width)
    }

    maxArea
  }

  val heights = Array(2, 1, 5, 6, 2, 3)
  val result = largestRectangleArea(heights)
  println(result)
}
