package LeetCode.greedy

object JumpGame extends App {
  def canJumpStrictNum(nums: Array[Int]): Boolean = {

    def _canJump(i: Int): Boolean = {
      if (i > nums.length) false
      else if (i == nums.length - 1) true
      else if (nums(i) == 0) false
      else {
        _canJump(i + nums(i))
      }
    }

    _canJump(nums(0) - 1)
  }

  def canJump(nums:Array[Int]):Boolean = {
    var goal = nums.length - 1

    for (i <- nums.length - 1 to 0 by -1) {
      if (i + nums(i) >= goal)
        goal = i
    }

    goal == 0
  }

  println(canJump(Array(2,3,1,1,4,2)))
  println(canJump(Array(3,2,1,0,4)))
}
