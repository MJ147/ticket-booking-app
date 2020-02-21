name := "ticket-booking-app"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= {
    val springBootVersion = "2.2.3.RELEASE"
    Seq(
      "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
      "org.springframework.boot" % "spring-boot-starter-data-jpa" % springBootVersion,
      "org.projectlombok" % "lombok" % "1.18.10" % "provided",
      "org.scalatest" %% "scalatest" % "3.1.1" % "test",
    )
}





