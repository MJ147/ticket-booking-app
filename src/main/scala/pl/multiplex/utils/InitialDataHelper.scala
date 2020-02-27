package pl.multiplex.utils

import org.springframework.stereotype.Component
import pl.multiplex.dao.TicketDao
import pl.multiplex.models.Ticket

@Component
class InitialDataHelper(ticketDao: TicketDao) {

  def setFlagOnTakenSitsOnInitialApp: Unit = {
    val ticketList: java.lang.Iterable[Ticket] = ticketDao.findAll()
    ticketList.forEach(t => t.getScreening.getSeats.find(s => s.toString == t.getSeatName()).get.setIsFree(false))

    ticketDao.saveAll(ticketList)
  }

}
