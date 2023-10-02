package LeetCode

object StringToInt extends App {
  def myAtoI(s: String): Int = {
    val numeric = s.split(" ").flatMap(x => try{
      Some(x.toInt)
    } catch {
      case e:Exception => None
    })

    if (numeric.length > 0) numeric.head else 0
  }

  val s:String = "This is a test and it seems to work +4193 with words"
  print(myAtoI(s))
}
