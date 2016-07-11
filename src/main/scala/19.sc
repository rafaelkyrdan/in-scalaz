import scalaz._, Scalaz._

/**
  * Either
  *
  */

1.right[String]

"error".left[Int]

Left[String, Int]("boom").right flatMap {
  x => Right[String, Int](x + 1)
}

for {
  e1 <- "event 1 ok".right
  e2 <- "event 2 failed!".left[String]
  e3 <- "event 3 failed!".left[String]
} yield (e1 |+| e2 |+| e3)


// getting value out of \/
"event 1 ok".right.isRight
"event 1 ok".right.isLeft
"event 2 failed!".left.isLeft

// getOrElse
"event 1 ok".right | "something bad"

// map
"event 1 ok".right map {_ + "!"}


// orElse
"event 1 failed!".left ||| "retry event 1 ok".right
