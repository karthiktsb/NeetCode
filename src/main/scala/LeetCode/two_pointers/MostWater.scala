package LeetCode.two_pointers

object MostWater extends App {
  def maxArea(height: Array[Int]): Int = {
    var maxArea = 0
    var left = 0
    var right = height.length - 1

    while (left < right) {
      var currentArea = Math.min(height(left), height(right)) * (right - left)
      maxArea = Math.max(maxArea, currentArea)

      if (height(left) < height(right))
        left += 1
      else
        right -= 1
    }

    maxArea
  }

  println(maxArea(Array(1,3,5,2,1)))
}
