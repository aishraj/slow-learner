package week4

import java.util.NoSuchElementException

/**
 * Created by ge3k on 17/5/14.
 */

class Cons[T] (val head: T, val tail : List[T]) extends List[T]{
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true

  override def tail: Nothing = throw new NoSuchElementException("Nil head")

  override def head: Nothing = throw new NoSuchElementException("Nil head")
}

object List {
  def apply[T](x1: T, x2: T) = List[T] = new Cons(x1,new Cons(x2, new Nil))
  def apply[T]() = new Nil
}
