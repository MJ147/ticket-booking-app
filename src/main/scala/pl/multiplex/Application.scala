package pl.multiplex

import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class Application

object Application extends App {
  SpringApplication.run(classOf[Application])

  /*
  Initial data helper - find seats which are used in initial data and flag them as taken:
  (This is because I cant forced Spring to use my own setter method in ticket model)
  */
  val post = new HttpPost("http://localhost:8080/data/gen")
  val client = HttpClients.createDefault()
  val response = client.execute(post)
}


