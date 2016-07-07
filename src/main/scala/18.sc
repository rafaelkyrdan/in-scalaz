import scalaz._, Scalaz._

/**
  * A stateful computation is a function that takes some
  * state and returns a value along with some new state.
  * That function would have the following type:
  * s -> (a, s)
  */


State[List[Int], Int] { case x :: xs => (xs, x) }




type Stack = List[Int]

val pop = State[Stack, Int] {
  case x :: xs => (xs, x)
}

def push(a: Int) = State[Stack, Unit] {
  case xs => (a :: xs, ())
}

def stackManip: State[Stack, Int] = for {
  _ <- push(3)
  a <- pop
  b <- pop
} yield (b)

stackManip(List(5, 8, 2, 1))



