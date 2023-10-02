package LeetCode.binary_search

object MinRotatedArray extends App {
  def findMin(nums: Array[Int]): Int = {
    var left = 0
    var right = nums.length - 1
    var currMin = Int.MaxValue

    while (left < right) {
      var mid = left + (right - left) / 2
      currMin = Math.min(currMin, nums(mid))

      if (nums(mid) > nums(right)) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }

    Math.min(currMin, nums(left))
  }

  println(findMin(Array(3,1,2)))
}
