package pl.multiplex.services

import java.time.{LocalDate, LocalTime}

import org.springframework.stereotype.Service

@Service
trait TicketService {

  def saveAll(title: String, date: LocalDate, time: LocalTime, firstName: String, secondName: String,
              seatName: java.util.List[String], ticketType: java.util.List[String]): String

}
