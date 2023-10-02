package LeetCode.arrays_and_hashes

import scala.collection.mutable.Set

object FindDuplicates extends App {
  def findDups(l:List[Int]): Boolean = {
    val seen: Set[Int] = Set()

    for (i <- l) {
      if (seen.contains(i)) return true
      seen.add(i)
    }

    false
  }

  val input = List(1,2,3,4,5,1)
  println(findDups(input))
}
