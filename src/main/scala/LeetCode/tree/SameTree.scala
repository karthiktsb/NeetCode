package LeetCode.tree

object SameTree extends App {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
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

    if (_isSameTree(Option(p), Option(q)) == -1) false else true
  }

  val root1 = new TreeNode(0, None, None)
  val l1 = new TreeNode(-1, None, None)
  val r1 = new TreeNode(1, None, None)
  val r2 = new TreeNode(2, None, None)
  val r3 = new TreeNode(3, None, None)
  root1.left = Option(l1)
  root1.right = Option(r1)
  r1.right = Option(r2)
  r2.right = Option(r3)

  val root2 = new TreeNode(0, None, None)
  val l21 = new TreeNode(-1, None, None)
  val r21 = new TreeNode(1, None, None)
  val r22 = new TreeNode(2, None, None)
  val r23 = new TreeNode(5, None, None)
  root2.left = Option(l21)
  root2.right = Option(r21)
  r21.right = Option(r22)
  r22.right = Option(r23)

  println(isSameTree(root1, root2))
}
