package pl.multiplex.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence._
import lombok.ToString

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

  def setSeatName(seatNumber: String): Unit = {
    this.seatNumber = seatNumber
    screening.getSeats().filter(s => s.toString.equals(seatNumber)).map(s => s.setIsFree(false))
  }

  def getSeatName(): String = {
    seatNumber
  }

}
