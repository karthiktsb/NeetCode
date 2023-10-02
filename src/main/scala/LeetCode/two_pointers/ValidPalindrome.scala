package LeetCode.two_pointers

object ValidPalindrome extends App {
  def isPalindrome(s: String): Boolean = {
    val str = s.toLowerCase.replaceAll("[^0-9a-z]", "")

    var left = 0
    var right = str.length - 1

    if (str.length > 1) {
      while (left < right) {
        if (str(left) != str(right)) return false
        left += 1
        right -= 1
      }
    }

    true
  }

  println(isPalindrome(""))
}
