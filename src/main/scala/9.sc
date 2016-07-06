import scalaz._, Scalaz._

/**
  *
  * Functor is a typeclass, which is supports map function
  * so it can be mapped over.
  *
  */


//Scalaz defines functor for tuple
(1, 2, 3) map {
  _ + 1
}


// and for function1
val ff = ((x: Int) => x + 1) map {
  _ * 3
}
ff(3)

(((x: Int) => x + 1) map {
  _ * 3
}) (3)
(((x: Int) => x + 1) map {
  _ * 3
}) (4)


//Functor also enables some operators that
// overrides the values in the data structure like >|,
// as, fpair, strengthL, strengthR, and void

List(1, 2, 3) >| 'x'
List(1, 2, 3) as 'x'
List(1,2,3).fpair
List(1, 2, 3).strengthL("x")
List(1, 2, 3).strengthR("x")
List(1,2,3).void












