lazy val test = (project in file("."))
  .settings(
    scalaVersion := "2.12.2"
  )

lazy val di = (project in file("di"))
  .settings(
    scalaVersion := "2.12.2",
    libraryDependencies ++= Seq(
      "org.scaldi" %% "scaldi" % "0.5.8"
    )
  )
