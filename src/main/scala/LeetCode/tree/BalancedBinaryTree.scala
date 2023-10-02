package LeetCode.tree

object BalancedBinaryTree extends App {
  def isBalanced(root: TreeNode): Boolean = {
    def _isBalanced(node: Option[TreeNode]): Int = {
      if (!node.isDefined) 0
      else {
        val leftDepth = _isBalanced(node.get.left)
        val rightDepth = _isBalanced(node.get.right)

        if (
          leftDepth == -1 || rightDepth == -1 ||
            Math.abs(leftDepth - rightDepth) > 1
        ) return -1

        Math.max(rightDepth, leftDepth) + 1
      }
    }
    _isBalanced(Option(root)) != -1
  }

  val root = new TreeNode(0, None, None)
  val l1 = new TreeNode(-1, None, None)
  val r1 = new TreeNode(10, None, None)
  val r2 = new TreeNode(20, None, None)
  val r3 = new TreeNode(30, None, None)
  var r4 = new TreeNode(5, None, None)
  var r5 = new TreeNode(8, None, None)
  var r6 = new TreeNode(9, None, None)
  root.left = Option(l1)
  root.right = Option(r1)
  r1.right = Option(r2)
  r1.left = Option(r4)
  r2.right = Option(r3)
  r4.right = Option(r5)
  r5.right = Option(r6)

  println(isBalanced(root))
}
