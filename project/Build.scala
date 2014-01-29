import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "demoservice"
  val appVersion = "1.0-SNAPSHOT"

  val liftVersion = "2.5-M4"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
    "com.google.code.gson" % "gson" % "2.2"
  ) ++ Seq(
    "net.liftweb" %% "lift-mongodb-record" % liftVersion,
    "org.scalatest" %% "scalatest" % "2.0" % "test",
    "org.mongodb" %% "casbah" % "2.5.0",
    "ch.qos.logback" % "logback-classic" % "1.0.9",
    "org.mongeez" % "mongeez" % "0.9.3",
    "org.springframework" % "spring-core" % "3.2.1.RELEASE",
    "log4j" % "log4j" % "1.2.17",
    "commons-lang" % "commons-lang" % "2.6",
    "com.foursquare" %% "rogue-field" % "2.2.0" intransitive(),
    "com.foursquare" %% "rogue-index" % "2.2.0" intransitive(),
    "com.foursquare" %% "rogue-core" % "2.2.0" intransitive(),
    "com.foursquare" %% "rogue-lift" % "2.2.0" intransitive(),
    "com.foursquare" % "fongo" % "1.0.7"
  )




  val main = play.Project(appName, appVersion, appDependencies).settings(
  // Add your own project settings here
  testOptions in Test := Nil,
  scalaVersion := "2.10.2",
  libraryDependencies ++= Seq(
    "com.softwaremill.macwire" %% "macros" % "0.5",
    "com.softwaremill.macwire" %% "runtime" % "0.5"
    )

  )

  parallelExecution in Test := false

}
