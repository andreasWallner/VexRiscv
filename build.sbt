val spinalVersion = "1.8.1"

lazy val spinalHdlIdslPlugin = ProjectRef(file("../SpinalHDL"), "idslplugin")
lazy val spinalHdlSim = ProjectRef(file("../SpinalHDL"), "sim")
lazy val spinalHdlCore = ProjectRef(file("../SpinalHDL"), "core")
lazy val spinalHdlLib = ProjectRef(file("../SpinalHDL"), "lib")

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.github.spinalhdl",
      scalaVersion := "2.11.12",
      version      := "2.0.0"
    )),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.5",
      "org.yaml" % "snakeyaml" % "1.8"
    ),
    name := "VexRiscv",
    scalacOptions += (spinalHdlIdslPlugin / Compile / packageBin / artifactPath).map { file => s"-Xplugin:${file.getAbsolutePath}" }.value
  ).dependsOn(spinalHdlCore, spinalHdlLib, spinalHdlSim, spinalHdlIdslPlugin)

fork := true
