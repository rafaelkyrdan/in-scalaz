import scalaz._, Scalaz._


/**
  * Writer
  *
  */


val a = 3.set("Smallish gang.")
val b = "something".tell

a.run
b.run


def logNumber(x: Int): Writer[List[String], Int] =
  x.set(List("Got number: " + x.shows))

def multWithLog: Writer[List[String], Int] = for {
  a <- logNumber(3)
  b <- logNumber(5)
} yield a * b

multWithLog.run



