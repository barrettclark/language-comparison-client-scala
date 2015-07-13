name := "client"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-encoding", "UTF-8",
  "-language:implicitConversions",
  "-Ywarn-dead-code",
  "-Ywarn-unused-import"
)

resolvers += "Twitter Repo"  at "http://maven.twtter.com"

libraryDependencies ++= {
  Seq(
    "com.twitter"               %%  "finagle-httpx" %   "6.25.0",
    "io.argonaut"               %%  "argonaut"      %   "6.1-M4",
    "com.github.nscala-time"    %%  "nscala-time"   %   "1.6.0"
  )
}
