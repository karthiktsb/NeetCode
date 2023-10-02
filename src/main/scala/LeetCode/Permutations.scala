package LeetCode

object Permutations extends App {
  val in = Array(0)
  var result: Array[List[Int]] = Array()

  for (i <- 0 until in.length + 1) {
    result = result ++ in.combinations(i).toArray.map(_.toList)
  }

  println(result.toList)
}
