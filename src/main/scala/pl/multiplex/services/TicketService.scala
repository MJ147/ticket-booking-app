package pl.multiplex.services

import java.time.{LocalDate, LocalTime}

import org.springframework.stereotype.Service
import pl.multiplex.models.Consumer

@Service
trait TicketService {

  def saveAll(title: String, date: LocalDate, time: LocalTime, consumer: Consumer,
              seatName: java.util.List[String], ticketType: java.util.List[String]): String

}
