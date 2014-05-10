object CurryingSum {
  /*def sum(f : Int => Int) : (Int, Int) => Int = {
    def sumF(a : Int, b : Int) : Int = {
      if (a > b) 0
      else f(a) + sumF(a+1,b)
    }
    sumF
  }*/
  def sum(f: Int => Int) (a : Int, b: Int): Int =
    if (a>b) 0 else f(a) + sum(f)(a+1,b)

  def sumInts = sum (x => x)
  //sumInts(1,10)
  sum (x => x) (1,10)
}