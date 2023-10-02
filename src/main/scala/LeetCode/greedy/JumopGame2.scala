package LeetCode.greedy

object JumopGame2 extends App {
  def jump(nums: Array[Int]): Int = {
    var result = 0
    var (l, r) = (0,0)

    while (r < nums.length - 1) {
      var farthest = 0
      for (i <- l to r) {
        farthest = Math.max(farthest, i + nums(i))
      }
      l = r + 1
      r = farthest
      result += 1
    }

    result
  }

  println(jump(Array(2,3,1,1,4)))
  println(jump(Array(2,3,0,1,4)))
  val a = List(1,2,2,3,3,4,4,5,6,7,7)
  val grouped = a.groupBy(identity)
  println(grouped.view.mapValues(x => x.length).toMap)
}
