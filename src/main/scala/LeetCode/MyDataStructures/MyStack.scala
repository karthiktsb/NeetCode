package LeetCode.MyDataStructures

class MyStack[T] {
  var list:List[T] = List()

  def push(in: T): Unit = {
    list = list :+ in
  }

  def pop():Option[T] = {
    if (list.isEmpty) None
    else {
      val element:T = list.last
      list = list.init
      Option(element)
    }
  }

  def top(): Option[T] = {
    if (list.isEmpty) None
    else Option(list.last)
  }

  def nonEmpty: Boolean = list.nonEmpty
  def isEmpty: Boolean = list.isEmpty
  def length: Int = list.length
}

object MyStack extends App {
  val stack: MyStack[Int] = new MyStack[Int]()

  stack.push(1)
  stack.push(2)
  stack.push(3)

  println(stack.top())
  println(stack.pop())
  println(stack.top())
  println(stack.nonEmpty)
  println(stack.length)
}
