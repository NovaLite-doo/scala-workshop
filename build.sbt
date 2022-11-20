ThisBuild / organization := "rs.novalite"
ThisBuild / scalaVersion := "2.13.10"

val setScalaSource = Compile / scalaSource := baseDirectory.value / "src"

lazy val task1 = (project in file("./task1"))
  .settings(
      name := "task1",
      setScalaSource
  )

lazy val task2 = (project in file("./task2"))
  .settings(
    name := "task2",
    setScalaSource
  )

lazy val task3 = (project in file("./task3"))
  .settings(
    name := "task3",
    setScalaSource
  )

lazy val root = (project in file("."))
  .settings(
    name := "scala-workshop-2022"
  )
  .aggregate(task1, task2, task3)