name := "play-aws-utils"

version := "4.0.3-SNAPSHOT"

organization := "nl.rhinofly"

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-ws" % "2.3.0" withSources(),
  "com.typesafe.play" %% "play-test" % "2.3.0" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)

publishTo := {
  Some("WiredThing Internal Forks Repository" at "https://wiredthing.artifactoryonline.com/wiredthing/libs-forked-local")
}

resolvers ++= Seq(
  "Typesafe Release Repository" at "http://repo.typesafe.com/typesafe/releases")  
  
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

scalacOptions += "-deprecation"
