package LeetCode

import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.ArrayDeque

object TryPriorityQueue extends App {

  val nums = Array(1,2,3,4,5,6,7)
  val pq = PriorityQueue(nums: _*)
  val k = 3

  while (pq.size > k) {
    pq.dequeue()
  }

  println(pq)
  pq.enqueue(0)
  println(pq)
  pq.dequeue()
  println(pq)
  pq.dequeue()
  println(pq)
  pq.dequeue()
  println(pq)
  pq.dequeue()
  println(pq)

  val adq = new ArrayDeque[Int]()

  adq ++= nums
  println(adq)
  adq.removeHead()
  println(adq)
  adq.removeLast()
  println(adq)
}
