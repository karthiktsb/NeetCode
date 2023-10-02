package LeetCode

object AddTwoNums extends App {
  def addNums(num1: String, num2: String): String = {
    def _addNum(str1: String, str2: String, carry: Int): String = {
      if (str1.length > 0 && str2.length > 0) {
        val sum = str1.last.toString.toInt + str2.last.toString.toInt + carry
        if (sum > 9) {
          _addNum(str1.init, str2.init, sum.toString.init.toInt) + sum.toString.last
        } else {
          _addNum(str1.init, str2.init, 0) + sum
        }
      } else if (str1.length == 0 && str2.length > 0) {
        val sum = str2.last.toString.toInt + carry
        if (sum > 9) {
          _addNum("", str2.init, sum.toString.init.toInt) + sum.toString.last
        } else {
          _addNum("", str2.init, 0) + sum
        }
      } else if (str2.length == 0 && str1.length > 0) {
        val sum = str1.last.toString.toInt + carry
        if (sum > 9) {
          _addNum(str1.init, "", sum.toString.init.toInt) + sum.toString.last
        } else {
          _addNum(str2.init, "", 0) + sum
        }
      } else {
        if (carry > 0) carry.toString
        else ""
      }
    }

    if (num1.length > 0 && num2.length > 0) {
      _addNum(num1, num2, 0)
    } else if (num1.length == 0) num2
    else num1

  }

  print(addNums("", ""))
}
