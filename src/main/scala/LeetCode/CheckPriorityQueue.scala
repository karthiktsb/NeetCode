package LeetCode

import scala.collection.mutable.PriorityQueue

object CheckPriorityQueue extends App {
  val priorityQueue = PriorityQueue.empty(Ordering[Int].reverse)

  priorityQueue.enqueue(7)
  priorityQueue.enqueue(8)
  priorityQueue.enqueue(6)
  priorityQueue.enqueue(1)


  val highestPriority1 = priorityQueue.dequeue()
  println(s"Highest priority element: $highestPriority1")

  val highestPriority2 = priorityQueue.dequeue()
  println(s"Highest priority element: $highestPriority2")

  println(priorityQueue)
}
