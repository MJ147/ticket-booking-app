package pl.multiplex.services.impl

import java.time.{LocalDate, LocalDateTime, LocalTime}

import org.springframework.stereotype.Service
import pl.multiplex.dao.{ScreeningDao, TicketDao}
import pl.multiplex.exceptions.{InvalidFirstNameOrSecondNameException, NoSeatSelectedException, SeatAlreadyTakenException, SingleSeatLeftException}
import pl.multiplex.models.{Consumer, Screening, Ticket, TicketType}
import pl.multiplex.services.{ConsumerService, TicketService}
import pl.multiplex.utils.SeatHelper


@Service
class TicketServiceImpl(val ticketDao: TicketDao, val screeningDao: ScreeningDao, val consumerService: ConsumerService) extends TicketService {

  override def saveAll(title: String, date: LocalDate, time: LocalTime, firstName: String, secondName: String,
                       seatNumbers: java.util.List[String], ticketTypes: java.util.List[String]): String = {

    var seatHelper: SeatHelper = null

    if (!isLeftAtLeast15MinutesToScreening(date, time)) {
      return "Nie można zarezerwować biletu. Seans rozpoczyna się za mniej niż 15 minut."
    }
    val screening: Screening = screeningDao.findFirstByTitleAndDateAndStartTime(title, date, time)
    if (screening == null) {
      return "Nie znaleziono seansu."
    }
    var consumer: Consumer = null
    try {
      consumer = consumerService.save(firstName, secondName)
    } catch {
      case e: InvalidFirstNameOrSecondNameException =>
        return e.getMessage
    }
    seatHelper = new SeatHelper(seatNumbers, screening)
    try {
      seatHelper.isSeatNamesAreCorrect()
    } catch {
      case e: NoSeatSelectedException =>
        return e.getMessage
      case _: IndexOutOfBoundsException =>
        return "Niepoprawny numer miejsca."
      case e: SeatAlreadyTakenException =>
        return e.getMessage
      case e: SingleSeatLeftException =>
        return e.getMessage
    }
    val ticketList: java.util.List[Ticket] = createTicketList(seatNumbers, ticketTypes, screening, consumer)
    ticketDao.saveAll(ticketList)
    val price: Double = ticketList.stream().mapToDouble(t => t.getTicketType.getPrice).sum()
    val bookingExpirationTime: LocalTime = time.minusMinutes(15)

    s"Liczba biletów: ${ticketList.size}, \nDo zapłaty: $price,\nRezerwacja przepada o godzinie: $bookingExpirationTime"
  }

  def createTicketList(seatNumbers: java.util.List[String], ticketTypes: java.util.List[String], screening: Screening, consumer: Consumer): java.util.List[Ticket] = {
    val ticketList: java.util.List[Ticket] = new java.util.ArrayList[Ticket]()
    for (i <- 0 until seatNumbers.size()) {
      val ticket = new Ticket()
      ticket.setScreening(screening)
      ticket.setTicketType(TicketType.valueOf(ticketTypes.get(i)))
      ticket.setConsumer(consumer)
      ticket.setSeatName(seatNumbers.get(i))
      ticketList.add(ticket)
    }
    ticketList
  }

  def isLeftAtLeast15MinutesToScreening(movieDate: LocalDate, movieTime: LocalTime): Boolean = {
    LocalDateTime.of(movieDate, movieTime).isAfter(LocalDateTime.now().plusMinutes(15))
  }


}
