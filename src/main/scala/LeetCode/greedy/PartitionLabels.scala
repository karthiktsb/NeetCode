package LeetCode.greedy

import scala.collection.mutable.Map

object PartitionLabels extends App {
  def partitionLabels(s: String): List[Int] = {
    var lastIndex = Map[Char, Int]()

    for (i <- s.distinct) {
      lastIndex.addOne(i, s.lastIndexOf(i))
    }

    var result = List[Int]()
    var (size, end) = (0,0)

    for ((c, i) <- s.zipWithIndex) {
      size += 1
      end = Math.max(end, lastIndex(c))
      if (i == end) {
        result = result :+ size
        size = 0
      }
    }
    result
  }

  println(partitionLabels("ababcbacadefegdehijhklij"))
  println(partitionLabels("eccbbbbdec"))
  println(partitionLabels("eccbbbbd"))
  println(partitionLabels("abcdef"))
}
