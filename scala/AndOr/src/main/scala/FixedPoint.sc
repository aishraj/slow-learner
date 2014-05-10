import math.abs

object FixedPoint {
  val acceptedError = 0.00001
  def isCloseEnough(a : Double,b : Double) =
     (abs(a-b)/a)/a < acceptedError
  def fixedPoint(f: Double => Double) (firstGuess : Double) = {
    def iterate(guess: Double) : Double = {
      val next = f(guess)
      if (isCloseEnough(guess,next)) guess
      else iterate(next)
    }
    iterate(firstGuess)
  }
  fixedPoint(x => 1 + x/2)(1)

  def averageDamp(f: Double => Double) (x : Double) = (x+f(x))/2

  def sqrt(x : Double) =
    fixedPoint(averageDamp(y=> x/y))(1)

  sqrt(2)
}