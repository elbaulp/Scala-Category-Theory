import sbt._

object Dependencies {

  // Libraries
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % "test"
  lazy val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"

  // Projects
  val backendDeps =
    Seq(scalaTest, scalaCheck)
}
