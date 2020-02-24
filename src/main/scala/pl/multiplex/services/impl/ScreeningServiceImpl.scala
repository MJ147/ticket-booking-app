package pl.multiplex.services.impl

import java.time.{LocalDate, LocalTime}

import org.springframework.stereotype.Service
import pl.multiplex.dao.ScreeningDao
import pl.multiplex.models.Screening
import pl.multiplex.services.ScreeningService


@Service
class ScreeningServiceImpl(val screeningDao: ScreeningDao) extends ScreeningService {

  override def findAllByDateAndStartTimeBetween(date: LocalDate, startTime: LocalTime): java.util.List[Array[Any]] = {
    val time1: LocalTime = startTime.minusHours(1)
    val time2: LocalTime = startTime.plusHours(1)
    screeningDao.findAllByDateAndStartTimeBetween(date, time1, time2)
  }

  override def findFirstByTitleAndDateAndStartTime(title: String, date: LocalDate, time: LocalTime): String = {
    val screening: Screening = screeningDao.findFirstByTitleAndDateAndStartTime(title, date, time)
    // Create list without taken seats
    val freeSeatsList = screening.getRoom.getSeats().to(LazyList).filter(s => s.getIsFree())
    s"Tytuł: ${screening.getMovie.getTitle},\nGodzina: ${screening.getStartTime},\nNumer sali: ${screening.getRoom.getId},\nIlość wolnych miejsc: ${freeSeatsList.size},\n" +
      s"Dostępne miejsca: ${freeSeatsList.toString.substring(8)}"
  }

}
