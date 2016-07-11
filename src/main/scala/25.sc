import scalaz._, Scalaz._

/**
  * Identity
  *
  */

// all data types can be Id of the type
(0:Id[Int])
1 + 2 + 3 |> {_.point[List]}
1 + 2 + 3 |> {_ * 6}
1 visit { case x@(2|3) => List(x * 2) }
2 visit { case x@(2|3) => List(x * 2) }

