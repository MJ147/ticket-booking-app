package pl.multiplex.models

import com.fasterxml.jackson.annotation.{JsonBackReference, JsonIgnore}
import javax.persistence._

import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer

@Entity
class Room extends Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @BeanProperty
  var rowsNumber: Int = 0
  @BeanProperty
  var seatsNumberInRow: Int = 0
  @OneToMany(mappedBy = "room")
  @JsonBackReference
  @BeanProperty
  var screening: java.util.List[Screening] = new java.util.ArrayList[Screening]()
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
    (rowsNumber, seatsNumberInRow) match {
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
