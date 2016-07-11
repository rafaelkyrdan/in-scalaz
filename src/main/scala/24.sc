import scalaz._, Scalaz._

/**
  * Zipper
  *
  */

Stream(1, 2, 3, 4)
Stream(1, 2, 3, 4).toZipper
Stream(1, 2, 3, 4).toZipper >>= {
  _.next
}

Stream(1, 2, 3, 4).toZipper >>= {
  _.next
} >>= {
  _.next
}

Stream(1, 2, 3, 4).toZipper >>= {
  _.next
} >>= {
  _.next
} >>= {
  _.previous
}

val res = Stream(1, 2, 3, 4).toZipper >>= {
  _.next
} >>= {
  _.next
} >>= {
  _.modify { _ => 7 }.some
}

res.get.toStream.toList

for {
  z <- Stream(1, 2, 3, 4).toZipper
  n1 <- z.next
  n2 <- n1.next
} yield { n2.modify {_ => 7} }





