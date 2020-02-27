package pl.multiplex.services

import org.springframework.stereotype.Service
import pl.multiplex.models.Consumer

@Service
trait ConsumerService {

  def save(firstName: String, secondName: String): Consumer

}
