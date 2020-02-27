package pl.multiplex.models

import java.time.{LocalDate, LocalTime}

import com.fasterxml.jackson.annotation.{JsonBackReference, JsonIgnore, JsonManagedReference}
import javax.persistence._
import lombok.ToString

import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer

@Entity
class Screening extends Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @BeanProperty
  var date: LocalDate = _
  @BeanProperty
  var startTime: LocalTime = _
  @OneToMany(mappedBy = "screening")
  @JsonBackReference
  @BeanProperty
  var tickets: java.util.List[Ticket] = new java.util.ArrayList[Ticket]()
  @OneToOne
  @JoinColumn(name = "movie_id", referencedColumnName = "id")
  @BeanProperty
  var movie: Movie = _
  @ManyToOne
  @JoinColumn(name = "room_id")
  @JsonManagedReference
  @ToString.Exclude
  @BeanProperty
  var room: Room = _
  @JsonIgnore
  private var seats: ListBuffer[Seat] = null

  def getSeats(): ListBuffer[Seat] = {
    (seats) match {
      case (s) if s == null =>
        createSeats()
        seats
      case _ =>
        seats
    }
  }

  def createSeats(): Unit = {
    (room.getRowsNumber, room.getSeatsNumberInRow) match {
      case (rowsNumber: Int, seatsNumberInRow: Int) if rowsNumber > 0 && seatsNumberInRow > 0 =>
        val temporaryListOfSeats = new ListBuffer[Seat]()
        for (i <- 1 to rowsNumber;
             j <- 1 to seatsNumberInRow) {
          val seat: Seat = new Seat(i, j)

          temporaryListOfSeats.addOne(seat)
        }
        this.seats = temporaryListOfSeats
      case _ =>
        throw new IllegalArgumentException("Wartość rzędu lub miejsca musi być większa od zera.")
    }
  }
}
