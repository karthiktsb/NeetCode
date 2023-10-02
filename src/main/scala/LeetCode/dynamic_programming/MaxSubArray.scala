package LeetCode.dynamic_programming

object MaxSubArray extends App {
  def maxProductSliding(nums: Array[Int]): Int = {
    def _product(index: Int): Int = {
      if (index > 0) Math.max(nums.sliding(index).map(_.product).toList.sortWith(_ > _).head, _product(index - 1))
      else Int.MinValue
    }
    _product(nums.length)
  }

  def maxProduct(nums: Array[Int]):Int = {
    var result = nums.max
    var (curMax, curMin) = (1,1)
    var temp = 0

    for (n <- nums) {
      temp = n * curMax
      curMax = Math.max(Math.max(n * curMax, n * curMin),n)
      curMin = Math.min(Math.max(temp, n * curMin), n)
      result = Math.max(curMax, result)
    }

    result
  }


  def checkDataType(in: Any): Unit = {
    in match {
      case (a: Int) => println("Here is plus 1 = " + (a + 1))
      case (a:String) => println("String type")
      case (a: Boolean) => if (a) println("Thats True") else println("Nope false")
      case _ => println("I dont know")
    }
  }

  println(maxProductSliding(Array(2, 3, -2, 4)))
  println(maxProduct(Array(2, 3, -2, 4)))
  println(maxProductSliding(Array(2, 0, -1)))
  println(maxProduct(Array(-1)))
  println(checkDataType(1))
  println(checkDataType("1"))
  println(checkDataType(true))
  println(checkDataType(1L))
}
