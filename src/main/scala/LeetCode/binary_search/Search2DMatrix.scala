package LeetCode.binary_search

object Search2DMatrix extends App {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val m = matrix.length
    val n = matrix(0).length
    var left = 0
    var right = m * n - 1

    while (left <= right) {
      var mid = left + (right - left) / 2
      var midValue = matrix(mid / n)(mid % n)

      if (midValue == target) {
        return true
      } else {
        if (target > midValue)
          left = mid + 1
        else
          right = mid - 1
      }
    }
    false
  }

  println(searchMatrix(Array(Array(1,3,5,7),Array(10,11,16,20),Array(23,30,34,60)), 7))

}
