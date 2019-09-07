organization := "am.hed"
version      := "1.0"
scalaVersion := "2.13.0"
crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.9", "2.13.0")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

coverageEnabled := true
