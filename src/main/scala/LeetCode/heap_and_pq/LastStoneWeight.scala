package LeetCode.heap_and_pq

import scala.collection.mutable.PriorityQueue

object LastStoneWeight extends App {
  def lastStoneWeight(stones: Array[Int]): Int = {
    val pq = PriorityQueue(stones: _*)

    while (pq.length > 1) {
      val stone1 = pq.dequeue()
      val stone2 = pq.dequeue()

      if (stone1 != stone2) pq.enqueue(Math.abs(stone1 - stone2))

    }

    if (pq.length > 0) pq.head else 0
  }

  println(lastStoneWeight(Array(2,7,4,1,8,1)))

}
