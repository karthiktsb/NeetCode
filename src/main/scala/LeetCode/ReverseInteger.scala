package LeetCode

object ReverseInteger extends App {
  def reverse(i: Int): Int = {
    val str = i.toString
    if (str.contains('-')) {
      str.replace("-","").reverse.toInt * -1
    } else {
      str.reverse.toInt
    }
  }

  val in:Int = -123
  println(reverse(in))
}
