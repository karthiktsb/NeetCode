package LeetCode.two_pointers

object ThreeSum extends App {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val numSorted = nums.sorted
    var result:List[List[Int]] = List()
    for (i <- 0 until numSorted.length - 2) {
      if (i == 0 || numSorted(i) != numSorted(i - 1)) {
        var left = i + 1
        var right = numSorted.length - 1

        while (left < right) {
          var sum = numSorted(i) + numSorted(left) + numSorted(right)

          if (sum == 0) {
            result = result :+ List(numSorted(i), numSorted(left), numSorted(right))

            while (left < right && numSorted(left) == numSorted(left + 1))
              left += 1
            while (right > left && numSorted(right) == numSorted(right - 1))
              right -= 1

            left += 1
            right -= 1
          } else if (sum < 0) {
            left += 1
          } else {
            right -= 1
          }
        }
      }
    }

    result
  }

  val nums = Array(-1,0,1,2,-1,-4)
  val triplets = threeSum(nums)
  println(triplets)

}
