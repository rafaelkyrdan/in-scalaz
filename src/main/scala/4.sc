import scalaz._, Scalaz._

/**
  * Equal
  * Eq is used for types that support equality testing.
  * The functions its members implement are == and /=
  *
  */


// The main difference is that === would fail
//compilation if you tried to compare Int and String.

1 === 1

//error
//1 === "foo"

//warning
1 == "foo"

//not equal
1.some =/= 2.some
1.some =/= 1.some

//runtime exception
1 assert_=== 2





