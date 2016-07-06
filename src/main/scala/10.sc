import scalaz._, Scalaz._

/**
  * Applicative functor knows how to apply function to a
  * value which is boxed in the  some context and return the new
  * value boxed in the same context.
  *
  */

List(1, 2, 3, 4) map {
  (_: Int) * (_: Int)
}.curried


//point is basically a constructor that
// takes value A and returns F[A]
1.point[List]
1.point[Option]
1.point[Option] map {
  _ + 1
}

1.point[List] map {
  _ + 1
}

//Aplicative style
9.some <*> {(_: Int) + 3}.some
1.some <* 2.some
none <* 2.some
1.some *> 2.some
none *> 2.some

^(3.some, 5.some) {_ + _}
^(3.some, none[Int]) {_ + _}

//Lists are applicative functors.
List(1, 2, 3) <*> List((_: Int) * 0, (_: Int) + 100, (x: Int) => x * x)
List(3, 4) <*> { List(1, 2) <*> List({(_: Int) + (_: Int)}.curried, {(_: Int) * (_: Int)}.curried) }
(List("ha", "heh", "hmm") |@| List("?", "!", ".")) {_ + _}








