package LeetCode.binary_search

object BinarySearch extends App {
  def binarySearch(nums: Array[Int], target:Int): Int = {
    var left = 0
    var right = nums.length - 1

    while (left <= right) {
      var mid = left + (right - left) / 2
      if (nums(mid) == target) {
        return mid
      } else {
        if (nums(mid) > target) {
          right = mid  - 1
        } else {
          left = mid + 1
        }
      }
    }

    -1
  }

  println(binarySearch(Array(-1,0,3,5,6,7,8,9,12),-1))
}
