package LeetCode.tree

object KthSmallest extends App {
  def kthSmallestList(root: TreeNode, k: Int): Int = {
    def _kth(node: Option[TreeNode]): List[Int] = {
      if (node.isDefined) {
        _kth(node.get.left) ::: List(node.get.value) :::  _kth(node.get.right)
      }
      else Nil
    }
    val result = _kth(Option(root))
    if (result.length >= k - 1) result(k - 1) else -1
  }

  def kthSmallest(root: TreeNode, k: Int): Int = {
    var count = 0
    var result = 0
    def _kth(node: Option[TreeNode]): Unit = {
      if (node.isDefined) {
        _kth(node.get.left)

        count += 1

        if (count == k) {
          result = node.get.value
          return
        }

        _kth(node.get.right)
      }
    }
    _kth(Option(root))

    result
  }

  val root = new TreeNode(0, None, None)
  val l1 = new TreeNode(-10, None, None)
  val r1 = new TreeNode(10, None, None)
  val l2 = new TreeNode(-20, None, None)
  val l3 = new TreeNode(-5, None, None)
  root.left = Some(l1)
  root.right = Option(r1)
  l1.left = Option(l2)
  l1.right= Option(l3)

  println(kthSmallest(root, 5))
}
