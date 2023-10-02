package LeetCode.heap_and_pq

import scala.collection.mutable.PriorityQueue

object PriorityQueueExample {
  def main(args: Array[String]): Unit = {
    // Create an empty priority queue with an implicit ordering
    val priorityQueue = PriorityQueue.empty[Int]

    // Enqueue elements with their priorities
    priorityQueue.enqueue(5)
    priorityQueue.enqueue(2)
    priorityQueue.enqueue(8)
    priorityQueue.enqueue(1)

    // Dequeue elements in priority order
    while (priorityQueue.nonEmpty) {
      val nextElement = priorityQueue.dequeue()
      println(s"Dequeued: $nextElement")
    }
  }
}