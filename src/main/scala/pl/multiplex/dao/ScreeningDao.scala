package pl.multiplex.dao

import java.lang
import java.time.{LocalDate, LocalTime}

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import pl.multiplex.models.{Screening}

@Repository
trait ScreeningDao extends CrudRepository[Screening, Long]{

  def findAllById(id: Long): lang.Iterable[Screening]

  @Query(value = "SELECT m.id, m.title, s.start_time From screening s INNER JOIN movie m ON s.movie_id = m.id WHERE s.date = :date AND s.start_time BETWEEN :time1 AND :time2", nativeQuery = true)
  def findAllByDateAndStartTimeBetween(@Param("date") date: LocalDate, @Param("time1") time1: LocalTime, @Param("time2") time2: LocalTime): java.util.List[Array[Any]]

}
