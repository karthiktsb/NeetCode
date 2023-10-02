package LeetCode.tree

class TreeNode(val value: Int, var left: Option[TreeNode], var right: Option[TreeNode])

class BinaryTree() {
  var head:Option[TreeNode] = None

  def add(in: Int): Unit = {
    val newNode = Option(new TreeNode(in, None, None))
    var current = head
    if (!head.isDefined) {
      head = newNode
    } else {
      while (current.isDefined) {
        if (in == current.get.value) {
          println("Value Already Exists")
          current = None
        }
        else if (in > current.get.value) {
          if (current.get.right.isDefined) current = current.get.right
          else {
            current.get.right = newNode
            current = None
          }
        } else {
          if (current.get.left.isDefined) current = current.get.left
          else {
            current.get.left = newNode
            current = None
          }
        }
      }
    }
  }

  def printTreeInOrder(): Unit = {
    def _printTree(treeNode: Option[TreeNode]): Unit = {
      if (treeNode.isDefined) {
        _printTree(treeNode.get.left)
        println(treeNode.get.value)
        _printTree(treeNode.get.right)
      }
    }
    _printTree(head)
  }

  def findInTree(in: Int): Boolean = {
    def _findInTree(treeNode: Option[TreeNode]): Boolean = {
      if (!treeNode.isDefined) false
      else if (in == treeNode.get.value) true
      else {
        if (in > treeNode.get.value) _findInTree(treeNode.get.right)
        else _findInTree(treeNode.get.left)
      }
    }
    _findInTree(head)
  }

  def min(): Int = {
    def _smallest(node: Option[TreeNode], value: Int): Int = {
      if (!node.isDefined) value
      else _smallest(node.get.left, node.get.value)
    }

    if (head.isDefined) _smallest(head, head.get.value)
    else Int.MinValue
  }

  def max(): Int = {
    def _max(node: Option[TreeNode], value: Int): Int = {
      if (!node.isDefined) value
      else _max(node.get.right, node.get.value)
    }

    if (head.isDefined) _max(head, head.get.value)
    else Int.MinValue
  }
}

object BinaryTree extends App {
  val newTree = new BinaryTree()
  newTree.add(0)
  newTree.add(6)
  newTree.add(4)
  newTree.add(2)
  newTree.add(1)
  newTree.add(5)
  newTree.add(8)
  newTree.add(-16)
  newTree.add(7)
  newTree.add(-12)
  newTree.add(19)
  newTree.printTreeInOrder()
  println(newTree.findInTree(-1))
  println(newTree.min())
  println(newTree.max())
}

