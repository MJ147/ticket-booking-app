package pl.multiplex.services.impl

import org.springframework.stereotype.Service
import pl.multiplex.dao.ConsumerDao
import pl.multiplex.models.Consumer
import pl.multiplex.services.ConsumerService


@Service
class ConsumerServiceImpl(val consumerDao: ConsumerDao) extends ConsumerService {

  override def save(firstName: String, secondName: String): Consumer = {
    val consumer: Consumer = new Consumer()
    consumer.setFirstName(firstName)
    consumer.setSecondName(secondName)

    consumerDao.save(consumer)
  }

}
