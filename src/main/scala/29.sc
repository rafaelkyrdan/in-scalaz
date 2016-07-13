import scalaz._, Scalaz._

/**
  * Traversal involves iterating over the elements of
  * a data structure, in the style of a map,
  * but interpreting certain function applications idiomatically
  */

List(1, 2, 3) traverse { x => (x > 0) option (x + 1) }
List(1, 2, 0) traverse { x => (x > 0) option (x + 1) }


List(1.some, 2.some).sequence
List(1.some, 2.some, none).sequence
