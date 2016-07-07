import scalaz._, Scalaz._

/**
  * Monad laws
  *
  */


// The first monad law states that if we take a value,
// put it in a default context with return and then feed
// it to a function by using >>=, it’s the same as just
// taking the value and applying the function to it.

(Monad[Option].point(3) >>= { x => (x + 100000).some }) assert_=== 3 |> { x => (x + 100000).some }


//The second law states that if we have a monadic value and we use >>=
// to feed it to return, the result is our original monadic value.
("move on up".some flatMap {
  Monad[Option].point(_)
}) assert_=== "move on up".some

// The final monad law says that when we have a chain of monadic
// function applications with >>=, it shouldn’t matter how
// they’re nested.
//type Birds = Int
//case class Pole(left: Birds, right: Birds)

//Monad[Option].point(Pole(0, 0)) >>= {_.landRight(2)} >>= {_.landLeft(2)} >>= {_.landRight(2)}
//Monad[Option].point(Pole(0, 0)) >>= { x =>
//  x.landRight(2) >>= { y =>
//    y.landLeft(2) >>= { z =>
//      z.landRight(2)
//    }
//  }
//}