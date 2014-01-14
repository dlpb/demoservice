// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "SonatypeRepo" at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1.2")