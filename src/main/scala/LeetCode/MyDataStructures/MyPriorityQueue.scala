package LeetCode.MyDataStructures

import scala.collection.mutable

class MyPriorityQueue[T](ordering: Ordering[T]) {
  var heap: Vector[T] = Vector.empty

  def enqueue(in: T): Unit = {
    heap = heap :+ in
    heap = heap.sorted(ordering)
  }

  def dequeue(): Option[T] = {
    if (heap.isEmpty) None
    else {
      val out = heap.last
      heap = heap.init
      Some(out)
    }
  }

  def peek(): Option[T] = {
    if (heap.isEmpty) None
    else {
      Some(heap.last)
    }
  }

  def size = heap.length

  def isEmpty = heap.isEmpty
}

object MyPriorityQueue extends App {
  val pq = new MyPriorityQueue[Int](Ordering.Int)

  pq.enqueue(8)
  pq.enqueue(2)
  pq.enqueue(1)
  pq.enqueue(10)


  for (i <- 0 to pq.size - 1) {
    val a = pq.dequeue()
    println(a)
  }

  val pqO = mutable.PriorityQueue.empty(Ordering.Int)

  pqO.enqueue(8)
  pqO.enqueue(2)
  pqO.enqueue(1)
  pqO.enqueue(10)


  for (i <- 0 to pqO.size - 1) {
    val a = pqO.dequeue()
    println(a)
  }


  val pq1 = new MyPriorityQueue[String](Ordering.String.reverse)

  pq1.enqueue("abc")
  pq1.enqueue("def")
  pq1.enqueue("bbc")

  for (i <- 0 to pq1.size - 1) {
    val a = pq1.dequeue()
    println(a)
  }

  def kthLargest(nums: Array[Int], k: Int): Int = {
    val pq = new MyPriorityQueue[Int](Ordering.Int.reverse)

    for (i <- 0 until nums.size) {
      if (i < k) pq.enqueue(nums(i))
      else {
        pq.enqueue(nums(i))
        pq.dequeue()
      }
    }
    pq.dequeue().get
  }

  println(kthLargest(Array(6,1,2,3,4,5), 2))
}
