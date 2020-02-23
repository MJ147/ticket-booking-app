package pl.multiplex.services

import java.time.{LocalDate, LocalTime}

import org.springframework.stereotype.Service

@Service
trait ScreeningService {

  def findAllByDateAndStartTimeBetween(date: LocalDate, startTime: LocalTime): java.util.List[Array[Any]]

}
