import scalaz._, Scalaz._

/**
  * Validation.
  * The difference between Validation and Either
  * is that it is not a monad, but it’s an applicative functor.
  *
  */

"event 1 ok".success[String]
"event 1 failed!".failure[String]


("event 1 ok".success[String] |@| "event 2 failed!".failure[String] |@| "event 3 failed!".failure[String]) {
  _ + _ + _
}


1.wrapNel
"event 1 ok".successNel[String]
"event 1 failed!".failureNel[String]
//In Failure, we were able to accumulate all failed messages.
("event 1 ok".successNel[String] |@| "event 2 failed!".failureNel[String] |@| "event 3 failed!".failureNel[String]) {
  _ + _ + _
}