package LeetCode.arrays_and_hashes

import scala.collection.mutable.Map

object TopKFrequentElements extends App {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    var counts = Map[Int, Int]()

    for (i <- nums) {
      if (counts.contains(i)) counts(i) = counts(i) + 1
      else counts(i) = 1
    }

    if (counts.toArray.length >= k)
      counts.toArray.sortWith(_._2 > _._2).take(k).map(_._1)
    else
      Array()
  }

  println(topKFrequent(Array(1,1,1,2,2,3), 2).toList)
  println(topKFrequent(Array(1), 1).toList)
  println(topKFrequent(Array(1,2,3,3), 2).toList)
}
