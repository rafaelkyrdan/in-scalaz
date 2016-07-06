import scalaz._, Scalaz._

/**
  * Enum - sequentially ordered types.
  * We can use its types in the list range.
  * There are a bunch of operations it enables
  * like -+-, ---, from, fromStep, pred, predx,
  * succ, succx, |-->, |->, |==>, and |=>.
  *
  */

'a' to 'e'

'a' |-> 'e'

3 |=> 5


'B'.succ

/**
  * Enum type is bounded type
  * it means that members have an upper and
  * lower bound
  */

implicitly[Enum[Char]].min
implicitly[Enum[Char]].max
implicitly[Enum[Double]].max
implicitly[Enum[Int]].min


