package LeetCode

object MedianOfTwoArrays extends App {
   def findMedian(num1: Array[Int], num2:Array[Int]): Double = {
     def mergeArrays(num1: Array[Int], num2:Array[Int]):Array[Int] = {
       if (num1.length == 0 || num2.length == 0) {
         if (num1.length ==0) num2
         else num1
       } else {
         if (num1.head < num2.head) Array(num1.head) ++ mergeArrays(num1.tail, num2)
         else Array(num2.head) ++ mergeArrays(num1, num2.tail)
       }
     }
     val merged = mergeArrays(num1, num2)

     if (merged.length % 2 == 1) merged(((merged.length + 1) / 2) - 1).toDouble
     else (merged(merged.length / 2).toDouble + merged((merged.length / 2) - 1).toDouble) / 2.0
   }


  println(findMedian(Array(1,2,3), Array(3,4,5,6,7)))
}
