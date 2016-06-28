/*
 This example shows how to create own Semigroup and Monoid
 */

//sum for int
def sum(l: List[Int]): Int = l.reduce(_ + _)
//this version is better because it cover case with emty list
//def sum(l: List[Int]): Int = l.foldLeft(0)(_ + _)
sum(List(1,2,3))

//sum for double
def sumDoubles(l: List[Double]): Double = l.reduce(_ + _)
//def sumDoubles(l: List[Double]): Double = l.foldLeft(0.0)(_ + _)
sumDoubles(List(1.3, 2.3, 3.3))

//sum for all Numeric
def sumNumeric[A](l: List[A])(implicit A: Numeric[A]): A =
  l.reduce(A.plus)

sumNumeric(List(1,2,3))
sumNumeric(List(1.3, 2.3, 3.3))

//sum for strings but it won't work sumNumeric
def sumStrings(l: List[String]): String = l.reduce(_ + _)
//def sumStrings(l: List[String]): String = l.foldLeft("")(_ + _)

sumStrings(List("a", "b", "c"))

//make it generic
//Semigroup
trait Addable[A] {
  def plus(x: A, y: A): A
}

object Addable {
  implicit def numericIsAddable[A](implicit A: Numeric[A]): Addable[A] =
    new Addable[A] {
      def plus(x: A, y: A): A = A.plus(x, y)
    }

  implicit val stringIsAddable: Addable[String] =
    new Addable[String] {
      def plus(x: String, y: String): String = x + y
    }


  //A good exercise at this point is to define an Addable instance for List[A].
  //I'm not sure that it right answer
//  implicit val listIsAddable: Addable[List[Addable]] =
//    new Addable[List[Addable]] {
//      override def plus(x: List[Addable], y: List[Addable]): List[Addable] =
//        x.++(y)
//    }
}

def sumGeneric[A](l: List[A])(implicit A: Addable[A]): A =
  l.reduce(A.plus)

//now it works for Numeric and String
//because they have a `plus` method
sumGeneric(List(1,2,3))
sumGeneric(List(1.3, 2.3, 3.3))
sumGeneric(List("a", "b", "c"))

//cover the case with empty list
//Monoid
trait AddableWithZero[A] extends Addable[A] {
  def zero: A
}

object AddableWithZero {
  implicit def numericIsAddableZero[A](implicit A: Numeric[A]): AddableWithZero[A] =
    new AddableWithZero[A] {
      def plus(x: A, y: A): A = A.plus(x, y)
      def zero: A = A.zero
    }

  implicit val stringIsAddableZero: AddableWithZero[String] =
    new AddableWithZero[String] {
      def plus(x: String, y: String): String = x + y
      def zero: String = ""
    }
}


def sumGeneric2[A](l: List[A])(implicit A: AddableWithZero[A]): A =
  l.foldLeft(A.zero)(A.plus)

sumGeneric2(List(1,2,3))
sumGeneric2(List(1.3, 2.3, 3.3))
sumGeneric2(List("a", "b", "c"))

//and now example with help from Scalaz
import scalaz.Monoid

def sumGeneric3[A](l: List[A])(implicit A: Monoid[A]): A =
  l.foldLeft(A.zero)((x, y) => A.append(x, y))


