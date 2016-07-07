import scalaz._, Scalaz._

/**
  * MonadPlus
  */

^(List(1, 2, 3), List(10, 100, 100)) {_ * _}
List(3, 4, 5) >>= {x => List(x, -x)}

for {
  x <- 1 |-> 50 if x.shows contains '7'
} yield x


//MonadPlus introduces filter operation.

(1 |-> 50) filter { x => x.shows contains '7' }
