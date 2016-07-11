import scalaz._, Scalaz._

/**
  * Kleisli is a special wrapper for function of type A => M[B]
  *
  */


val f = Kleisli { (x: Int) => (x + 1).some }
val g = Kleisli { (x: Int) => (x * 100).some }

// f compose g
4.some >>= (f <=< g)
4.some >>= (f >=> g)