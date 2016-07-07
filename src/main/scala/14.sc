import scalaz._, Scalaz._

/**
  * Monad is an extension of applicative functor
  * and provides a solution to the problem:
  * how to apply a function that takes a normal value to a value
  * with context and return the value with the context.
  *
  */

Monad[Option].point("WHAT")
9.some flatMap { x => Monad[Option].point(x * 10) }
(none: Option[Int]) flatMap { x => Monad[Option].point(x * 10) }


type Birds = Int

case class Pole(left: Birds, right: Birds) {
  def landLeft(n: Birds): Option[Pole] =
    if (math.abs((left + n) - right) < 4) {
      copy(left = left + n).some
    }
    else {
      none
    }

  def landRight(n: Birds): Option[Pole] =
    if (math.abs(left - (right + n)) < 4) {
      copy(right = right + n).some
    }
    else {
      none
    }
}

Pole(0, 0).landLeft(2)
Pole(0, 3).landLeft(10)
Pole(0, 0).landLeft(2)
Pole(1, 2).landRight(1)
Pole(1, 2).landRight(-1)

Pole(0, 0).landRight(1) flatMap {
  _.landLeft(2)
}
(none: Option[Pole]) flatMap {
  _.landLeft(2)
}
Monad[Option].point(Pole(0, 0)) flatMap {
  _.landRight(2)
} flatMap {
  _.landLeft(2)
} flatMap {
  _.landRight(2)
}



3.some >>= { x => "!".some >>= { y => (x.shows + y).some } }

//when we bind monadic values to names,
// we can utilize pattern matching
def justH: Option[Char] =
  for {
    (x :: xs) <- "hello".toList.some
  } yield x

// When pattern matching fails, the fail function is called.
// It’s part of the Monad type class and it enables failed pattern matching to result in a failure in the context of the current monad
def wopwop: Option[Char] =
  for {
    (x :: xs) <- "".toList.some
  } yield x





