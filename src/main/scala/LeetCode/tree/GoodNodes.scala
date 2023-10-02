package LeetCode.tree

object GoodNodes extends App {
  def goodNodes(root: TreeNode): Int = {
    def _goodNodes(node: Option[TreeNode], maxVal: Int): Int = {
      if (node.isDefined) {
        val current = if (node.get.value > maxVal)  1 else 0
        current + _goodNodes(node.get.left, Math.max(maxVal, node.get.value)) + _goodNodes(node.get.right, Math.max(maxVal, node.get.value))
      } else 0
    }

    _goodNodes(Option(root), Int.MinValue)
  }

  val root = new TreeNode(0, None, None)
  val l1 = new TreeNode(-10, None, None)
  val r1 = new TreeNode(10, None, None)
  val l2 = new TreeNode(-20, None, None)
  val l3 = new TreeNode(-5, None, None)
  val r2 = new TreeNode(15, None, None)
  val r3 = new TreeNode(5, None, None)
  val r5 = new TreeNode(25, None, None)
  root.left = Some(l1)
  root.right = Option(r1)
  l1.left = Option(l2)
  l1.right = Option(l3)
  r1.right = Option(r2)
  r1.left = Option(r3)
  r2.right = Option(r5)

  println(goodNodes(root))
}
