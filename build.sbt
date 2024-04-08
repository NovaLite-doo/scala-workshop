ThisBuild / organization := "rs.novalite"
ThisBuild / scalaVersion := "2.13.13"
ThisBuild / scalafmtOnCompile := true

lazy val root = (project in file("."))
  .settings(
    name := "scala-workshop",
    libraryDependencies ++= Seq(
      "org.scala-lang" %% "toolkit" % "0.2.1"
    )
  )