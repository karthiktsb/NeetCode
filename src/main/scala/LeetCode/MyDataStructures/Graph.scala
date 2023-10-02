package LeetCode.MyDataStructures

import scala.collection.mutable.HashMap

class GraphNode[T](val value:T) {
  var adjacencyList: List[GraphNode[T]] = List()
}

class Graph[T] {
  private val nodes = HashMap[T, GraphNode[T]]()

  def addNode(in: T) = {
    if (!nodes.contains(in)) {
      nodes(in) = new GraphNode[T](in)
    }
  }

  def addEdge(a: T, b:T) = {
    val node1 = nodes.getOrElse(a, new GraphNode[T](a))
    val node2 = nodes.getOrElse(b, new GraphNode[T](b))

    node1.adjacencyList = node1.adjacencyList :+ node2
    node2.adjacencyList ::= node1

    nodes(a) = node1
    nodes(b) = node2
  }

  def getNeighbours(in: T): List[GraphNode[T]] = {
    if (nodes.contains(in)) {
      nodes(in).adjacencyList
    } else List()
  }

  def contains(in: T): Boolean = {
    nodes.contains(in)
  }

  def printGraph(): Unit = {
    for (i <- nodes.keys) {
      println(nodes(i).value + " -> " + nodes(i).adjacencyList.map(_.value).mkString(","))
    }
  }
}

object Graph {
  def apply[T]():Graph[T] = new Graph[T]()
}

object GraphExec extends App {
  val graph = Graph[Int]()

  graph.addNode(1)
  graph.addNode(2)
  graph.addEdge(1,2)
  graph.addEdge(2,3)
  graph.addEdge(3,4)

  graph.printGraph()
  graph.getNeighbours(2)
}
