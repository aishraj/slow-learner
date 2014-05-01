object NewtonsMethod {
  def abs(x: Double) = if (x < 0) -x else x

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess)/2

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)
  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.001

  def sqrt(s : Double) = sqrtIter(1,s)

  sqrt(2)
  sqrt(1e-6)
  sqrt(1e60)

}
