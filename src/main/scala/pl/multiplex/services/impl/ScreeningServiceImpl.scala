package pl.multiplex.services.impl

import java.time.{LocalDate, LocalTime}

import org.springframework.stereotype.Service
import pl.multiplex.dao.ScreeningDao
import pl.multiplex.services.ScreeningService


@Service
class ScreeningServiceImpl(val screeningDao: ScreeningDao) extends ScreeningService {

  override def findAllByDateAndStartTimeBetween(date: LocalDate, startTime: LocalTime): java.util.List[Array[Any]] = {
    val time1: LocalTime = startTime.minusHours(1)
    val time2: LocalTime = startTime.plusHours(1)
    screeningDao.findAllByDateAndStartTimeBetween(date, time1, time2)
  }

}
