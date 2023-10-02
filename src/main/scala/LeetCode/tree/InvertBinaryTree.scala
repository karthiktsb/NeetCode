package LeetCode.tree

object InvertBinaryTree extends App {
 def invertTree (root: TreeNode): TreeNode = {
   def _invert(node: Option[TreeNode]): Unit = {
     if (node.isDefined) {
       val curr = node.get
       val temp = curr.left
       curr.left = curr.right
       curr.right = temp
       _invert(curr.left)
       _invert(curr.right)
     }
   }
   _invert(Option(root))
   root
  }

  def printTreeInOrder(root: TreeNode): Unit = {
    def _printTree(treeNode: Option[TreeNode]): Unit = {
      if (treeNode.isDefined) {
        _printTree(treeNode.get.left)
        println(treeNode.get.value)
        _printTree(treeNode.get.right)
      }
    }

    _printTree(Option(root))
  }



  val root = new TreeNode(4, None, None)
  val l1 = new TreeNode(2, None, None)
  val l2 = new TreeNode(1, None, None)
  val l3 = new TreeNode(3, None, None)
  val r1 = new TreeNode(7, None, None)
  val r2 = new TreeNode(6, None, None)
  val r3 = new TreeNode(9, None, None)

  root.left = Option(l1)
  //root.left = None
  root.right = Option(r1)
  l1.left = Option(l2)
  l1.right = Option(l3)
  r1.left = Option(r2)
  r1.right = Option(r3)

  printTreeInOrder(root)
  println("------------------")
  invertTree(root)
  printTreeInOrder(root)
}
