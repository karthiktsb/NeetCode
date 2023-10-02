package LeetCode.tree

object ValidBST extends App {
  def isValidBST(root: TreeNode): Boolean = {
    def _isValidBST(node: Option[TreeNode]): Int = {
      if (node.isDefined) {
        val left = if (node.get.left.isDefined) {
          if (node.get.value > node.get.left.get.value) {
            _isValidBST(node.get.left)
          } else {
            -1
          }
        } else 0

        val right = if (node.get.right.isDefined) {
          if (node.get.value < node.get.right.get.value) {
            _isValidBST(node.get.right)
          } else {
            -1
          }
        } else 0

        if (left == -1 || right == -1) -1 else 0
      } else 0
    }

    _isValidBST(Option(root)) != -1
  }

  val root = new TreeNode(0, None, None)
  val l1 = new TreeNode(-10, None, None)
  val r1 = new TreeNode(10, None, None)
  val r2 = new TreeNode(5, None, None)
  val r3 = new TreeNode(6, None, None)
  val l2 = new TreeNode(-20, None, None)
  val l3 = new TreeNode(-5, None, None)
  root.left = Some(l1)
  root.right = Option(r1)
  l1.left = Option(l2)
  l1.right = Option(l3)
  r1.left = Option(r2)
  r1.right = Option(r3)

  println(isValidBST(root))
}
