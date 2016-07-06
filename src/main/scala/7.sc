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
