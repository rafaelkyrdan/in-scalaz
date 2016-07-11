import scalaz._, Scalaz._

/**
  * Monadic functions
  *
  */

// any nested monadic value can be flattened
(Some(9.some): Option[Option[Int]]).join
(Some(none): Option[Option[Int]]).join
List(List(1, 2, 3), List(4, 5, 6)).join
9.right[String].right[String].join
"boom".left[Int].right[String].join


// The filterM function from Control.Monad
// is predicate that returns a monadic value
// whose result is a Bool.

List(1, 2, 3) filterM { x => List(true, false) }

//import syntax.std.vector._
//Vector(1, 2, 3) filterM { x => Vector(true, false) }


def binSmalls(acc: Int, x: Int): Option[Int] = {
  if (x > 9) (none: Option[Int])
  else (acc + x).some
}

// foldLeftM
List(2, 8, 3, 1).foldLeftM(0) {binSmalls}
List(2, 11, 3, 1).foldLeftM(0) {binSmalls}
