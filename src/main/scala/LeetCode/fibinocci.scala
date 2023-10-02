package LeetCode

object fibinocci extends App {
  def gen_fibinnoci(limit: Int): List[Int] ={
    def _gen_fib(num: Int, i: Int, j: Int): List[Int] = {
      if (num == limit) List(j)
      else if (num == 0) List(i, j) ::: _gen_fib(num + 1, j, i+j)
      else j :: _gen_fib(num + 1, j, i+j)
    }
    if (limit == 0) List(0,1) else _gen_fib(0, 0, 1)
  }

  def gen_fibinocci_while(target: Int): List[Int] = {
    var output = List[Int](0,1)
    var j = output(0)
    var k = output(1)
    var temp = 0
    while ( (k + j) <= target) {
      output = output ++ List(k + j)
      temp = j
      j = k
      k = k + temp
    }

    output
  }


  def fibinocci(n: Int): Int = {
    if (n <= 1) n
    else fibinocci(n - 1) + fibinocci(n - 2)
  }

  println(gen_fibinnoci(10))
  println(gen_fibinocci_while(0))
  val n = 15
  val res = Array.fill(n)(0)
  for (i <- 0 until n) {
    res(i) = fibinocci(i)
  }
  println(res.toList)
}
