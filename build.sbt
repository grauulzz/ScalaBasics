name := "basics"

version := "0.1"

scalaVersion := "3.1.0"

lazy val hello = taskKey[Unit]("An example task")

lazy val root = (project in file("."))
  .settings(
    hello := { println("Hello!") }
  )


