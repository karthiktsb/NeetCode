package LeetCode.binary_search

object SearchInRotatedSortedArray extends App {
  def search(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length - 1

    while (left <= right) {
      var mid = (left + right) / 2
      if (nums(mid) == target)
        return mid

      if (nums(mid) > nums(left)) {
        if (target > nums(mid) || target < nums(left)) {
          left = mid + 1
        } else {
          right = mid - 1
        }
      } else {
        if (target < nums(mid) || target > nums(right)) {
          right = mid - 1
        } else {
          left = mid + 1
        }
      }
    }
    -1
  }

  println(search(Array(4,5,6,7,0,1,2),6))
}
