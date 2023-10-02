package LeetCode.arrays_and_hashes

object GroupAnagrams extends App {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.map(x => (x,x.sorted)).groupBy(_._2).map(_._2.map(_._1).toList).toList
  }

  println(groupAnagrams(Array("eat","tea","tan","ate","nat","bat")))
}
