import scalaz._, Scalaz._

/**
  * Arrows
  *
  */


// The meaning of >>> and <<< depends on the arrow,
// but for functions, it’s the same as andThen and compose
val f = (_:Int) + 1
val g = (_:Int) * 100

(f >>> g)(2)
(f <<< g)(2)

// (***) combines two arrows into a new arrow
// by running the two arrows on a pair of values
// (one arrow on the first item of the pair and
// one arrow on the second item of the pair)
(f *** g)(1, 2)

// (&&&) combines two arrows into a new arrow
// by running the two arrows on the same value

(f &&& g)(2)