/**
  * Another example with monoid
  *
  */

trait Monoid[A] {
  def mappend(a1: A, a2: A): A
  def mzero: A
}

object IntMonoid extends Monoid[Int] {
  def mappend(a: Int, b: Int): Int = a + b
  def mzero: Int = 0
}

def sum(xs: List[Int], m: Monoid[Int]): Int =
  xs.foldLeft(m.mzero)(m.mappend)

sum(List(1, 2, 3, 4), IntMonoid)

//more general
def sum[A](xs: List[A], m: Monoid[A]): A =
  xs.foldLeft(m.mzero)(m.mappend)

sum(List(1, 2, 3, 4), IntMonoid)

//make monoid implicit
def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
  xs.foldLeft(m.mzero)(m.mappend)

implicit val intMonoid = IntMonoid
sum(List(1, 2, 3, 4))







