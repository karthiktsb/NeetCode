package LeetCode.heap_and_pq

import scala.collection.mutable.PriorityQueue

object KthLargestElement extends App {

  def kthLargest(nums: Array[Int], k: Int): Int = {
    val pq = PriorityQueue.empty(Ordering.Int.reverse)

    for (i <- 0 until nums.size) {
      if (i < k) pq.enqueue(nums(i))
      else {
        pq.enqueue(nums(i))
        pq.dequeue()
      }
      println("Head = " + pq.head)
    }
    pq.head
  }

  println(kthLargest(Array(6,1,2,3,4,5), 1))
}
