package pl.multiplex.services.impl

import java.time.{LocalDate, LocalDateTime, LocalTime}

import org.springframework.stereotype.Service
import pl.multiplex.WrongFirstNameOrSecondNameException
import pl.multiplex.dao.{ScreeningDao, TicketDao}
import pl.multiplex.models.{Consumer, Screening, Ticket, TicketType}
import pl.multiplex.services.{ConsumerService, TicketService}


@Service
class TicketServiceImpl(val ticketDao: TicketDao, val screeningDao: ScreeningDao, val consumerService: ConsumerService) extends TicketService {

  override def saveAll(title: String, date: LocalDate, time: LocalTime, firstName: String, secondName: String,
                       seatNames: java.util.List[String], ticketTypes: java.util.List[String]): String = {

    if (!isLeftAtLeast15MinutesToScreening(date, time)) {
      return "Nie można zarezerwować biletu. Seans rozpoczyna się za mniej niż 15 minut."
    }
    val ticketList: java.util.List[Ticket] = new java.util.ArrayList[Ticket]()

      val screening: Screening = screeningDao.findFirstByTitleAndDateAndStartTime(title, date, time)
      if (screening == null) {
        return "Nie znaleziono seansu."
      }
      var consumer: Consumer = null
      try {
        consumer = consumerService.save(firstName, secondName)
      } catch {
        case e: WrongFirstNameOrSecondNameException =>
          return e.getMessage
      }

      for (i <- 0 until seatNames.size()) {
        val ticket = new Ticket()
        ticket.setScreening(screening)
        ticket.setTicketType(TicketType.valueOf(ticketTypes.get(i)))
        ticket.setConsumer(consumer)
        ticket.setSeatName(seatNames.get(i))
        ticketList.add(ticket)
      }
      ticketDao.saveAll(ticketList)
      val price: Double = ticketList.stream().mapToDouble(t => t.getTicketType.getPrice).sum()
      val bookingExpirationTime: LocalTime = time.minusMinutes(15)
      s"Liczba biletów: ${ticketList.size}, \nDo zapłaty: $price,\nRezerwacja przepada o godzinie: $bookingExpirationTime"
  }

  def isLeftAtLeast15MinutesToScreening(movieDate: LocalDate, movieTime: LocalTime): Boolean = {
    LocalDateTime.of(movieDate, movieTime).isAfter(LocalDateTime.now().plusMinutes(15))
  }


}
