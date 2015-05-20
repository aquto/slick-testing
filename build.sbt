name := "slick-testing"

version := "0.0.1"

scalaVersion := "2.11.2"

parallelExecution in Test := false

resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.0.0"

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"

libraryDependencies +=  "com.zaxxer" % "HikariCP-java6" % "2.3.3"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"

autoCompilerPlugins := true

scalacOptions += "-feature"
