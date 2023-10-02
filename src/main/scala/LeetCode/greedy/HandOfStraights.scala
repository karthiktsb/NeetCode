package LeetCode.greedy

import scala.collection.mutable.Map

object HandOfStraights extends App {
  def isNStraightHand(hand: Array[Int], groupSize: Int): Boolean = {
    var lkp = Map[Int, Int]()

    if (groupSize == 1) {
      true
    } else if (hand.length % groupSize == 0) {
      for (i <- hand) {
        if (lkp.contains(i)) lkp(i) =  lkp(i)  + 1
        else lkp.addOne(i, 1)
      }
      var i = 0
      var foundGroup = 1
      var count = groupSize
      while ( i < hand.length / groupSize && count == groupSize) {
        var currItem = lkp.min._1
        if (lkp(currItem) > 1) lkp(currItem) = lkp(currItem) - 1
        else lkp.remove(currItem)
        count = 1
        while (count < groupSize && lkp.contains(currItem + 1)) {
          if (lkp(currItem + 1) > 1) lkp(currItem + 1)  = lkp(currItem + 1) - 1
          else lkp.remove(currItem + 1)
          count += 1
          currItem += 1
        }
        if (count == groupSize) {
          i += 1
        }
      }
      if (i == hand.length / groupSize) true else false
    } else {
      false
    }
  }

  println(isNStraightHand(Array(8,10,12),3))
  println(isNStraightHand(Array(2,1),2))
  println(isNStraightHand(Array(1),1))
  println(isNStraightHand(Array(1,2,3,6,2,3,4,7,8),3))
  println(isNStraightHand(Array(1,2,3,4,5,6),4))
}
