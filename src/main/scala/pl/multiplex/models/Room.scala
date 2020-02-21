package pl.multiplex.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id, MapsId, OneToOne}
import lombok.{Data, Getter, ToString}

import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer

@Data
@Entity
class Room(@BeanProperty
           val rowsNumber: Int,
           @BeanProperty
           val seatsNumberInRow: Int) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @BeanProperty
  val seats: List[Seat] = createSeats()
  @OneToOne
  @MapsId
  @JsonBackReference
  @ToString.Exclude
  @BeanProperty
  var screening: Screening = _

  def createSeats(): List[Seat] = {
    (rowsNumber, seatsNumberInRow) match {
      case (rowsNumber: Int, seatsNumberInRow: Int) if rowsNumber > 0 && seatsNumberInRow > 0 =>
        var temporaryListOfSeats = new ListBuffer[Seat]()
        for (i <- 1 to rowsNumber;
             j <- 1 to seatsNumberInRow) {
          var seat: Seat = new Seat(i, j)
          temporaryListOfSeats.addOne(seat)
        }
          temporaryListOfSeats.toList
      case _ =>
        throw new IllegalArgumentException("Wartość rzędu lub miejsca nie może być zerowa.")
    }
  }
}
