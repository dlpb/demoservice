import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "demoservice"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
      anorm,

  "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  "com.google.code.gson" % "gson" % "2.2"
  )



  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    testOptions in Test := Nil


  )

}
