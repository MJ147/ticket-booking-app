#!/bin/sh
app=ticket-booking-app.jar
mvn clean install
cd target
mv ticket-booking-app-1.0-SNAPSHOT.jar $app
java -jar $app

