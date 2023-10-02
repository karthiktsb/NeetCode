package LeetCode.MyDataStructures

class MyMap[K, V] {
  var map: Array[List[(K,V)]] = Array.fill(100)(List())

  def hash(input: K): Int = input.hashCode() % 100

  def add(key: K, value: V): Unit = {
    val hashValue = hash(key)
    map(hashValue) = map(hashValue) :+ (key, value)
  }

  def get(key: K): Option[V] = {
    val hashValue = hash(key)
    /*if (map(hashValue).length > 0 ) {
      map(hashValue).filter(_._1 == key).map(_._2).headOption
    }
    else None*/
    map(hashValue).collectFirst({ case (k, v) if k == key => v})
  }

  def getOrElse(key: K, default: V): V = {
    this.get(key) match {
      case Some(a) => a
      case None => default
    }
  }

  def contains(key: K): Boolean = {
    val hashValue = hash(key)
    if (map(hashValue).length > 0) {
      map(hashValue).map(_._1).contains(key)
    }
    else false
  }

  def apply(key: K): V = {
    this.get(key) match {
      case Some(a) => a
      case None => throw new NoSuchElementException("Key - " + key + " not found in the map")
    }
  }

  def update(key: K, value: V): Unit = {
    this.get(key) match {
      case Some(_) => {
        val hashCode = hash(key)
        var updateList = map(hashCode)
        val index = updateList.indexOf(key)
        updateList = updateList.slice(0, index) ++ List((key, value)) ++ updateList.slice(index + 1, updateList.length)
        map(hashCode) = updateList
      }
      case None => this.add(key, value)
    }
  }

  def +=(key: K, value: V): Unit = this.add(key, value)

}

object MyMap extends App {
  var myMap:MyMap[Int, String] = new MyMap[Int, String]()

  myMap.add(1,"One")
  myMap.add(2, "Two")
  myMap.add(3, "Three")
  myMap += (4, "Four")

  println(myMap.contains(3))
  println(myMap.contains(1))
  println(myMap.get(1))
  println(myMap.get(4))
  println(myMap.getOrElse(4, "Abcd"))
  println(myMap(1))
  //println(myMap(4))
  myMap(2) = "TwoTwo"

  println(myMap(1))
  println(myMap(2))
  println(myMap(3))
  println(myMap(4))
}
