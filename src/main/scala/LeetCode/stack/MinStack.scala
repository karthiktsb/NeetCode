package LeetCode.stack

import scala.collection.mutable.Stack

class MinStack() {
  var mainStack:Stack[Int] = Stack()
  var minStack:Stack[Int] = Stack()

  def push(i: Int) {
    mainStack.push(i)

    if (minStack.isEmpty || i <= minStack.top) {
      minStack.push(i)
    }
  }

  def pop(): Unit = {
    if (mainStack.nonEmpty) {
      val popped = mainStack.pop()

      if (minStack.top == popped) {
        minStack.pop()
      }
    }
  }

  def top(): Int = {
    if (mainStack.nonEmpty) mainStack.top else throw new NoSuchElementException("Stack is empty.")
  }

  def getMin(): Int = {
    if (minStack.nonEmpty) minStack.top else throw new NoSuchElementException("Stack is empty.")
  }

}

object MinStack extends App {
  val minStack = new MinStack()

  minStack.push(1)
  minStack.push(-1)

  println(minStack.getMin())
  println(minStack.top)
  minStack.pop()

  println(minStack.getMin())
  println(minStack.top)
}
