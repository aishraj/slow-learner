object FactorialTailRecursive {
  def factorial(n : Int) = {
    def loop(acc : Int, x : Int) : Int =
      if (x == 0) acc
      else loop (acc * x, x-1)
    loop(1,n)
  }
  factorial(4)
}