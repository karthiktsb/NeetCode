package LeetCode.MyDataStructures

import scala.collection.mutable

class MyPriorityQueue[T](ordering: Ordering[T]) {
  var heap: Vector[T] = Vector.empty

  /*def enqueue(in: T): Unit = {
    heap = heap :+ in
    heap = heap.sorted(ordering)
  }*/

  def enqueue(in: T): Unit = {
    if (heap.isEmpty) heap = heap :+ in
    else {
      val insertIndex = findInsertIndex(in)
      if (insertIndex >= 0) {
        heap = heap.slice(0, insertIndex) ++ Vector(in) ++ heap.slice(insertIndex, heap.length)
      }
    }
  }

  /*def dequeue(): Option[T] = {
    if (heap.isEmpty) None
    else {
      val out = heap.last
      heap = heap.init
      Some(out)
    }
  }*/

  def dequeue(): Option[T] = {
    if (heap.isEmpty) None
    else {
      val element = heap.head
      heap = heap.tail
      Option(element)
    }
  }

  def peek(): Option[T] = {
    if (heap.isEmpty) None
    else {
      Some(heap.head)
    }
  }

  def findInsertIndex(input: T): Int = {
    if (ordering.compare(input, heap.head) > 0) 0
    else if (ordering.compare(input, heap.last) < 0) heap.length
    else {
      var left = 0
      var right = heap.length - 1


      while (left <= right) {
        var mid = left + (right - left) / 2
        if (input == heap(mid)) {
          return -1
        } else {
          if (ordering.compare(input,heap(mid)) < 0) {
            left = mid + 1
          } else {
            right = mid - 1
          }
        }
      }

      left
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
  pq.enqueue(2)

  println(pq.peek())
  for (i <- 0 to pq.size - 1) {
    val a = pq.dequeue()
    println(a)
  }

  println("--------")
  val pqO = mutable.PriorityQueue.empty(Ordering.Int)

  pqO.enqueue(8)
  pqO.enqueue(2)
  pqO.enqueue(1)
  pqO.enqueue(10)
  pq.enqueue(1)

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

}
