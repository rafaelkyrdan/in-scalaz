import scalaz._, Scalaz._

/**
  * A monoid is when you have an associative binary
  * function and a value which acts as an identity
  * with respect to that function.
  *
  */


Monoid[List[Int]].zero
Monoid[String].zero

Tags.Multiplication(10) |+| Monoid[Int @@ Tags.Multiplication].zero

def lengthCompare(lhs: String, rhs: String): Ordering =
  (lhs.length ?|? rhs.length) |+| (lhs ?|? rhs)

lengthCompare("zen", "ants")
lengthCompare("zen", "ant")
