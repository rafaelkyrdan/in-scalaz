name := "in-scalaz"

version := "1.0"

scalaVersion := "2.11.8"

//val scalazVersion = "7.0.6"
val scalazVersion = "7.2.4"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

scalacOptions += "-feature"

//initialCommands in console := "import scalaz._, Scalaz._"
    