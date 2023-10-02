package LeetCode.arrays_and_hashes

object LongestSequence extends App {
  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0

    val numSet = nums.toSet
    var longestSeq = 0

    for (num <- nums) {
      if (!numSet.contains(num - 1)) {
        var curNum = num
        var curSeq = 1

        while (numSet.contains(curNum + 1)) {
          curNum += 1
          curSeq += 1
        }

        longestSeq = math.max(longestSeq, curSeq)
      }
    }

    return longestSeq
  }

  println(longestConsecutive(Array(99,100,4,200,1,3,2,103,104,102,101)))
}
