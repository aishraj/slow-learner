object CurryingProduct {
  def product(f: Int => Int) (a : Int, b: Int) : Int =
    if (a > b) 1 else f(a) * product(f) (a+1,b)
  product(x => x) (2,5)
  def factorial(n: Int)  = product(x => x) (1,n)
  factorial(0)
  def mapReduce(f: Int=> Int, combine: (Int ,Int) => Int, zero : Int) (a: Int, b: Int) : Int =
    if (a > b) zero else combine(f(a),mapReduce(f,combine,zero) (a+1,b) )

  def mapRProduct (f: Int => Int) (a : Int, b: Int) : Int =  mapReduce(f,(x,y) => x*y,1) (a,b)
  mapRProduct(x => x) (2,5)

}