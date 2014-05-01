object NewtonsMethod {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x : Double) = {

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001


    sqrtIter(1)
  }
  sqrt(2)
  sqrt(1e-6)
  sqrt(1e60)
}
