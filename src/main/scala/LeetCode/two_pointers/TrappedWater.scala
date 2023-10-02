package LeetCode.two_pointers

object TrappedWater extends App {
  def trap(height: Array[Int]): Int = {
    var left = 0
    var right = height.length - 1
    var leftMax = 0
    var rightMax = 0
    var trappedWater = 0

    while (left < right) {
      if (height(left) < height(right)) {
        if (height(left) >= leftMax)
          leftMax = height(left)
        else
          trappedWater += leftMax - height(left)
        left += 1
      } else {
        if (height(right) >= rightMax)
          rightMax = height(right)
        else
          trappedWater += rightMax - height(right)
        right -= 1
      }
    }

    trappedWater
  }

  println(trap(Array(0,1,0,2,1,0,1,3,2,1,2,1)))
}
