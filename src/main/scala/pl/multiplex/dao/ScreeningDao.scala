package pl.multiplex.dao

import java.time.{LocalDate, LocalTime}

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import pl.multiplex.models.Screening

@Repository
trait ScreeningDao extends CrudRepository[Screening, Long] {

  @Query(value = "SELECT m.title, s.start_time From screening s INNER JOIN movie m ON s.movie_id = m.id WHERE s.date = :date AND s.start_time BETWEEN :time1 AND :time2 ORDER BY m.title, s.start_time", nativeQuery = true)
  def findAllByDateAndStartTimeBetweenAndSortByTitleAndStartTime(@Param("date") date: LocalDate, @Param("time1") time1: LocalTime, @Param("time2") time2: LocalTime): java.util.List[Array[Any]]

  @Query(value = "SELECT DISTINCT * From screening s INNER JOIN movie m ON s.movie_id = m.id WHERE m.title = :title AND s.date = :date AND s.start_time = :time", nativeQuery = true)
  def findFirstByTitleAndDateAndStartTime(@Param("title") title: String, @Param("date") date: LocalDate, @Param("time") time: LocalTime): Screening
}
