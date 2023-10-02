package LeetCode.tree

object SubTreeOfANotherTree extends App {
  def isSubtree(root: TreeNode, subRoot: TreeNode): Boolean = {
    def _findRootElement(node: Option[TreeNode]): TreeNode = {
      if (!node.isDefined) null
      else {
        val current = node.get.value
        if (current == subRoot.value) node.get
        else {
          _findRootElement(node.get.right)
          _findRootElement(node.get.left)
        }
      }
    }

    def _isSameTree(a: Option[TreeNode], b: Option[TreeNode]): Int = {
      if (a.isDefined && b.isDefined) {
        if (a.get.value == b.get.value) {
          val left = _isSameTree(a.get.left, b.get.left)
          val right = _isSameTree(a.get.right, b.get.right)

          if (left == -1 || right == -1) -1 else 0
        } else -1
      } else if (!a.isDefined && !b.isDefined) 0
      else -1
    }

    if (root == null || subRoot == null) false
    else {
      val subNode = _findRootElement(Option(root))
      if (subNode == null) false
      else {
        if (_isSameTree(Option(subNode), Option(subRoot)) == -1) false else true
      }
    }
  }

  val root = new TreeNode(3, None, None)
  val l1 = new TreeNode(4, None, None)
  val l1l1 = new TreeNode(1, None, None)
  val l1r1 = new TreeNode(2, None, None)
  val r1 = new TreeNode(5, None, None)

  root.left = Option(l1)
  root.right = Option(r1)
  l1.left = Option(l1l1)
  l1.right = Option(l1r1)

  val subRoot = new TreeNode(4, None, None)
  val l2 = new TreeNode(1, None, None)
  val r2 = new TreeNode(2, None, None)

  subRoot.left = Option(l2)
  subRoot.right = Option(r2)

  println(isSubtree(root, subRoot))

}
