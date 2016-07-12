import scalaz._, Scalaz._

/**
  * Lens
  *
  */

case class Point(x: Double, y: Double)

case class Color(r: Byte, g: Byte, b: Byte)

case class Turtle(position: Point, heading: Double, color: Color) {
  def forward(dist: Double): Turtle =
    copy(position =
      position.copy(
        x = position.x + dist * math.cos(heading),
        y = position.y + dist * math.sin(heading)
      ))
}

val t = Turtle(Point(2.0, 3.0), 0.0, Color(255.toByte, 255.toByte, 255.toByte))
t.forward(10.0)

// The idea is to get rid of unnecessary
// copy calls insight the forward method

val turtlePosition = Lens.lensu[Turtle, Point](
  (a, value) => a.copy(position = value),
  _.position
)

val pointX = Lens.lensu[Point, Double](
  (a, value) => a.copy(x = value),
  _.x
)

val turtleX = turtlePosition >=> pointX
val t0 = Turtle(Point(2.0, 3.0), 0.0, Color(255.toByte, 255.toByte, 255.toByte))

turtleX.get(t0)
turtleX.set(t0, 5.0)
turtleX.mod(_ + 1.0, t0)
val incX = turtleX =>= {
  _ + 1.0
}
incX(t0)

val turtleHeading = Lens.lensu[Turtle, Double](
  (a, value) => a.copy(heading = value),
  _.heading
)

val pointY = Lens.lensu[Point, Double](
  (a, value) => a.copy(y = value),
  _.y
)

val turtleY = turtlePosition >=> pointY

def forward(dist: Double) = for {
  heading <- turtleHeading
  x <- turtleX += dist * math.cos(heading)
  y <- turtleY += dist * math.sin(heading)
} yield (x, y)

forward(10.0)(t0)
forward(10.0) exec (t0)





