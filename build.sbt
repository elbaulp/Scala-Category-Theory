import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.elbaulp",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Category Theory",
    logBuffered in Test := false,
    libraryDependencies ++= backendDeps
  )
