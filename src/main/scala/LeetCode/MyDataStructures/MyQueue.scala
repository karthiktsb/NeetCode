package LeetCode.MyDataStructures

class MyQueue[T] {
  var list: List[T] = List[T]()

  def enqueue(in: T): Unit = {
    list = list :+ in
  }

  def dequeue():Option[T] = {
    if (list.nonEmpty) {
      val element = list.head
      list = list.tail
      Option(element)
    } else None
  }

  def front(): Option[T] = {
    if (list.nonEmpty) {
      Option(list.head)
    } else None
  }

  def rear(): Option[T] = {
    if (list.nonEmpty) {
      Option(list.last)
    } else None
  }

  def isEmpty: Boolean = list.isEmpty
  def nonEmpty: Boolean = list.nonEmpty
  def length: Int = list.length
}

object MyQueue extends App {
  val myQueue: MyQueue[String] = new MyQueue[String]()

  myQueue.enqueue("abc")
  myQueue.enqueue("def")
  myQueue.enqueue("hij")

  println(myQueue.front)
  println(myQueue.rear)
  println(myQueue.dequeue())
  println(myQueue.length)
  println(myQueue.front)
  println(myQueue.rear)

}
