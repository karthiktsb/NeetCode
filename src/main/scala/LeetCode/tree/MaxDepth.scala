package LeetCode.tree

object MaxDepth extends App {
  def maxDepth(root: TreeNode): Int = {
    def _maxDepth(node: Option[TreeNode], depth: Int): Int = {
      if (!node.isDefined) depth
      else {
        Math.max(
          _maxDepth(node.get.right, depth + 1),
          _maxDepth(node.get.left, depth + 1)
        )
      }
    }
    _maxDepth(Option(root), 0)
  }

  val root = new TreeNode(0, None, None)
  val l1 = new TreeNode(-1, None, None)
  val r1 = new TreeNode(1, None, None)
  val r2 = new TreeNode(2, None, None)
  val r3 = new TreeNode(3, None, None)
  root.left = Option(l1)
  root.right = Option(r1)
  r1.right = Option(r2)
  r2.right = Option(r3)
  println(maxDepth(root))

}
