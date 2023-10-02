package LeetCode.sliding_window

import scala.collection.mutable.ArrayDeque

object MaxSlidingWindow extends App {

  def maxArray(nums: Array[Int]): Int = {
    def _maxArray(i: Int): Int = {
      if (i == nums.length) Int.MinValue
      else Math.max(nums(i), _maxArray(i + 1))
    }

    if (nums.length > 0) _maxArray(0) else -1
  }

  def maxSlidingWindowTraditional(nums: Array[Int], k: Int): Array[Int] = {
    def _maxSliding(i: Int): Array[Int] = {
      if (i + k == nums.length) {
        Array(maxArray(nums.slice(i, i + k)))
      } else {
        Array(maxArray(nums.slice(i, i + k))) ++ _maxSliding(i + 1)
      }
    }

    _maxSliding(0)
  }

  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    if (nums.isEmpty) return Array.empty[Int]

    val result = Array.ofDim[Int](nums.length - k + 1)
    val deque = new ArrayDeque[Int]()

    for (i <- nums.indices) {
      // Remove elements that are out of the current window from the front of the deque
      println(i)
      println(nums(i))
      println(deque)
      while (deque.nonEmpty && deque.head < i - k + 1) {
        deque.removeHead()
      }

      // Remove elements that are smaller than the current element from the back of the deque
      while (deque.nonEmpty && nums(deque.last) < nums(i)) {
        deque.removeLast()
      }

      // Add the current element's index to the back of the deque
      deque.addOne(i)

      // Store the maximum element of the current window in the result array
      if (i >= k - 1) {
        result(i - k + 1) = nums(deque.head)
      }
    }

    result
  }


  println(maxSlidingWindow(Array(1,3,-1,-3,5,3,6,7), 3).toList)
}
