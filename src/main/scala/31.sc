import scalaz._, Scalaz._

/**
  * Memo - returns a function
  * than may cache the result
  *
  */

val slowFib: Int => Int = {
  case 0 => 0
  case 1 => 1
  case n => slowFib(n - 2) + slowFib(n - 1)
}

slowFib(30)

// memoized version
val memoizedFib: Int => Int = Memo.mutableHashMapMemo {
  case 0 => 0
  case 1 => 1
  case n => memoizedFib(n - 2) + memoizedFib(n - 1)
}

memoizedFib(30)

