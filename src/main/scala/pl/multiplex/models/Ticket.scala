package pl.multiplex.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence._
import lombok.ToString
import pl.multiplex.exceptions.InvalidSeatNameException

import scala.beans.BeanProperty

@Entity
class Ticket extends Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @ManyToOne
  @JoinColumn(name = "consumer")
  @JsonManagedReference
  @ToString.Exclude
  @BeanProperty
  var consumer: Consumer = _
  @ManyToOne
  @JoinColumn(name = "screening")
  @JsonManagedReference
  @ToString.Exclude
  @BeanProperty
  var screening: Screening = _
  @BeanProperty
  @Enumerated(EnumType.STRING)
  var ticketType: TicketType = TicketType.ADULT

  private var seatNumber: String = _

  @throws(classOf[InvalidSeatNameException])
  def setSeatName(seatName: String): Unit = {
    this.seatNumber = seatName
    if (!screening.getSeats().filter(s => s.toString.equals(seatName)).isEmpty && screening.getSeats().filter(s => s.toString.equals(seatName))(0).getIsFree() != false) {
      screening.getSeats().filter(s => s.toString.equals(seatName)).map(s => s.setIsFree(false))
    } else {
      throw InvalidSeatNameException()
    }

  }

  def getSeatName(): String = {
    seatNumber
  }


}
