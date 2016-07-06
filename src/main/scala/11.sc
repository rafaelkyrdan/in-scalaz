import scalaz._, Scalaz._

/**
  * Tagged type is made for cases
  * when we want to just take one type and wrap
  * it in something to present it as another type.
  *
  */



sealed trait KiloGram
def KiloGram[A](a: A): A @@ KiloGram = Tag[A, KiloGram](a)

val mass = KiloGram(20.0)
2 * 20


sealed trait JoulePerKiloGram
def JoulePerKiloGram[A](a: A): A @@ JoulePerKiloGram =
  Tag[A, JoulePerKiloGram](a)


def energyR(m: Double @@ KiloGram): Double @@ JoulePerKiloGram =
  JoulePerKiloGram(299792458.0 * 299792458.0 * m)

energyR(mass)

