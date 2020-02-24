name := "ticket-booking-app"

version := "0.1"

scalaVersion := "2.13.1"

ThisBuild / useCoursier := false

libraryDependencies ++= {
    val springBootVersion = "2.2.3.RELEASE"
    Seq(
      "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
      "org.springframework.boot" % "spring-boot-starter-data-jpa" % springBootVersion,
      "org.projectlombok" % "lombok" % "1.18.10" % "provided",
      "org.scalatest" %% "scalatest" % "3.1.1" % "test",
      "org.postgresql" % "postgresql" % "42.2.10",
      "org.hibernate" % "hibernate-core" % "5.4.12.Final",
      "net.liftweb" %% "lift-json" % "3.4.1"
  )
}





