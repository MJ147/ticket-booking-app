package pl.multiplex.services.impl

import org.springframework.stereotype.Service
import pl.multiplex.WrongFirstNameOrSecondNameException
import pl.multiplex.dao.ConsumerDao
import pl.multiplex.models.Consumer
import pl.multiplex.services.ConsumerService


@Service
class ConsumerServiceImpl(val consumerDao: ConsumerDao) extends ConsumerService {

  @throws(classOf[WrongFirstNameOrSecondNameException])
  override def save(firstName: String, secondName: String): Consumer = {
    if (!(isFirstCapitalLetterAndMin3CharLong(firstName) && isTwoPartSecondNameSeparateDash(secondName))) {
      throw WrongFirstNameOrSecondNameException()
    }
    val consumer: Consumer = new Consumer()
    consumer.setFirstName(firstName)
    consumer.setSecondName(secondName)

    consumerDao.save(consumer)
  }

  def isFirstCapitalLetterAndMin3CharLong(text: String): Boolean = {
    text.matches("[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]{2,}")
  }

  def isTwoPartSecondNameSeparateDash(text: String): Boolean = {
    text.matches("[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]{2,}(_[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]{2,})?")
  }

}
