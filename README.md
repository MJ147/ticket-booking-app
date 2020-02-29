# ticket-booking-app
The seat reservation system for a multiplex.

## Table of contents
* [Screenshots](#screenshots)
* [General info](#general-info)
* [Setup](#setup)
* [Inspiration](#inspiration)
* [Technologies](#technologies)

## General info
The application is created in Scala mainly, howaver in some case where i couldn't force Spring to work with Scala, I have to use Java features. 
For example I have to use Java collectios or enum. 
At first I used PostgreSQL and SBT, than I decide to swich to the H2 database and Maven.
Maven, becouse it turned out much simpler during building and running application by a script. H2 becouse I want to use in-memory database.

## Inspiration
The application is a recruitment task.
Creating the application I mainly used:
- stackoverflow.com
- baeldung.com
- alvinalexander.com/scala/
- akademiascali.pl

## Setup
To run project open file run.sh with Git Bash. Database and initial data set up automaticly. 
To run demo open file demo.sh with Git Bash, when run.sh is still running. 

## Technologies
* Scala
* Java 8
* Maven
* Spring 5
* Spring Boot 2
* H2 Database
