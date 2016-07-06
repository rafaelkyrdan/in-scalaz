import scalaz._, Scalaz._

/**
  * Functor laws
  *
  */


// The `first functor law` states that if we map the identity
// function over a functor, the functor that we get back should
// be the same as the original functor.

List(1, 2, 3) map {
  identity
} assert_=== List(1, 2, 3)


// The second law says that composing two functions and
// then mapping the resulting function over a functor should
// be the same as first mapping one function over the functor
// and then mapping the other one.

(List(1, 2, 3) map {{(_: Int) * 3} map {(_: Int) + 1}}) assert_===
  (List(1, 2, 3) map {(_: Int) * 3} map {(_: Int) + 1})
