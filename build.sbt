
name := "scalapsl"

organization := "com.github.workingDog"

version := (ThisBuild / version).value

scalaVersion := "2.13.4"

libraryDependencies ++= List(
  "com.typesafe" % "config" % "1.4.1",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0"
)

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

assembly / test := {}

assembly / assemblyMergeStrategy := {
  case PathList(xs@_*) if xs.last.toLowerCase endsWith ".dsa" => MergeStrategy.discard
  case PathList(xs@_*) if xs.last.toLowerCase endsWith ".sf" => MergeStrategy.discard
  case PathList(xs@_*) if xs.last.toLowerCase endsWith ".des" => MergeStrategy.discard
  case PathList(xs@_*) if xs.last endsWith "LICENSES.txt" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}

homepage := Some(url("https://github.com/worldline-messaging/scalaPSL"))

licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

assembly / assemblyJarName := "scalapsl-" + version.value + ".jar"

