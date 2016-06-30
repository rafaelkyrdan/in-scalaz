import scalaz.Monoid

/*
    This example shows the generic fold function
    for list and tree.
 */

trait Foldable[F[_]] {
  // Instead of requiring the contents to be monoidal, let's
  // make it flexible by allowing a fold as long as we can convert
  // the contents to a type that has a `Monoid`.
  def foldMap[A, B](fa: F[A])(f: A => B)(implicit B: Monoid[B]): B
}

sealed trait Tree[A]
case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]
case class Leaf[A]() extends Tree[A]

object Foldable {
  implicit val listIsFoldable: Foldable[List] =
    new Foldable[List] {
      def foldMap[A, B](fa: List[A])(f: A => B)(implicit B: Monoid[B]): B =
        fa.foldLeft(B.zero)((acc, elem) => B.append(acc, f(elem)))
    }

  implicit val treeIsFoldable: Foldable[Tree] =
    new Foldable[Tree] {
      def foldMap[A, B](fa: Tree[A])(f: A => B)(implicit B: Monoid[B]): B =
        fa match {
          case Leaf() =>
            B.zero
          case Node(value, left, right) =>
            B.append(f(value), B.append(foldMap(left)(f), foldMap(right)(f)))
        }
    }
}

//doesn't work with scalaz7
//def sumGeneric[F[_], A](fa: F[A])(implicit F: Foldable[F], A: Monoid[A]): A =
//  fa.foldMap(identity(x:A))

import scalaz.{ Foldable, Monoid }

//doesn't work with scalaz7
//// Note that this is equivalent to scalaz.Foldable#fold
//def sumGeneric[F[_], A](fa: F[A])(implicit F: Foldable[F], A: Monoid[A]): A =
//  fa.fold














