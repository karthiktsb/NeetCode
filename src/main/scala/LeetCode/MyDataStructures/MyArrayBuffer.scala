package LeetCode.MyDataStructures

import scala.reflect.ClassTag

class MyArrayBuffer[T: ClassTag] {
  var buffer: Array[T] = new Array[T](5)
  var size = 0

  def apply(i: Int): T = {
    if (i <= size - 1) {
      buffer(i)
    } else {
      throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bound")
    }
  }

  def update(i: Int, input: T): Unit = {
    if (i <= size - 1) {
      buffer(i) = input
    } else {
      throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bound")
    }
  }

  def +=(input: T): Unit = {
    if (size >= buffer.length) {
      var newArray: Array[T] = new Array[T](buffer.size * 2)
      Array.copy(buffer, 0, newArray, 0, buffer.length)
      buffer = newArray
      buffer(size) = input
    } else {
      buffer(size) = input
    }
    size += 1
  }

  def insert(index: Int, value: T): Unit = {
    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException("Index " + index + " shoule be > 0")
    } else if (index > size) {
      throw new ArrayIndexOutOfBoundsException("Index " + index + " shoule be > 0 and < " + size)
    } else {
      var newArray: Array[T] = if (size >= buffer.length) new Array[T](buffer.size * 2)
      else new Array[T](buffer.size)
      Array.copy(buffer, 0, newArray, 0, index)
      newArray(index) = value
      Array.copy(buffer, index, newArray, index + 1, size - index)
      buffer = newArray
      size += 1
    }
  }

  def add(input: T) = this += input
  def :+(input: T) = this += input

  def length: Int = size
  def isEmpty: Boolean = size == 0
  def nonEmpty: Boolean = size != 0
}

object MyArrayBuffer {
  def apply[T: ClassTag]():MyArrayBuffer[T] = new MyArrayBuffer[T]()

  def apply[T: ClassTag](in: T*):MyArrayBuffer[T] = {
    var array = new MyArrayBuffer[T]()
    val it: Iterator[T] = in.toIterator

    while(it.hasNext) {
      val item = it.next()
      array += item
    }

    array
  }
}

object MyArrayBufferRun extends App {
  var ab: MyArrayBuffer[Any] = MyArrayBuffer[Any]("6",'7',8,List(9),0)

  println(ab.size)
  for (i <- 0 to ab.size - 1) {
    println(ab(i))
  }
  println("__________")
  ab.add(1)
  /*ab.add(5)
  ab.add(6)
  ab.add(7)
  ab.add(17)
  ab.add(27)
  ab.add(37)
  ab.add(47)
  ab.add(57)
  ab.add(76)*/
  ab(2) = 10
  ab += 67
  ab :+ 87
  //println(ab(0))

  ab insert(2, 100)
  for (i <- 0 to ab.size - 1) {
    println(ab(i))
  }
  println(ab.size)
}
