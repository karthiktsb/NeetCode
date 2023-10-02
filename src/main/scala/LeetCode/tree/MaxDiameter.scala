package LeetCode.tree

object MaxDiameter extends App {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    var maxDiameter = 0

    def _maxDiameter(node: Option[TreeNode]): Int = {
      if (!node.isDefined) 0
      else {
        val leftDepth = _maxDiameter(node.get.left)
        val rightDepth = _maxDiameter(node.get.right)

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth + 1)

        Math.max(leftDepth, rightDepth) + 1
      }
    }

    _maxDiameter(Option(root))

    maxDiameter
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
  println(diameterOfBinaryTree(root))
}
