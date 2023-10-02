package LeetCode.heap_and_pq

import scala.collection.mutable.PriorityQueue

class KthLargest(k: Int, nums: Array[Int]) {
  private val pq = PriorityQueue.empty(Ordering[Int].reverse)

  for (num <- nums) {
    pq.enqueue(num)
    if (pq.size > k) pq.dequeue()
  }

  def add(num: Int): Int = {
    if (pq.size < k) {
      pq.enqueue(num)
    } else {
      pq.dequeue()
      pq.enqueue(num)
    }
    println(pq)
    pq.head
  }
}

object KthLargest extends App {
  val kTh = new KthLargest(3, Array(1,2,3,4,5,6))

  println(kTh.add(7))
}
