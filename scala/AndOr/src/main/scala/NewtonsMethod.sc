object NewtonsMethod {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(s : Double) = {

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) / 2

    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def isGoodEnough(guess: Double, x: Double) =
      abs(guess * guess - x) / x < 0.001


    sqrtIter(1, s)
  }
  sqrt(2)
  sqrt(1e-6)
  sqrt(1e60)
}
