package week4

/**
 * Created by ge3k on 17/5/14.
 */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

