import scalaz._, Scalaz._

/**
  * Order
  * Ord is for types that have an ordering.
  * Ord covers all the standard comparing functions such as >, <, >= and <=.
  *
  */

1 > 2.0

//error
//comparing Int and Doube fails compilation
//1 gt 2.0


1 gt 2

//Order enables ?|? syntax which returns
// Ordering: LT, GT, and EQ.
// It also enables lt, gt, lte, gte, min, and max
// operators by declaring order method.

1.0 ?|? 2.0
1.0 max 2.0





