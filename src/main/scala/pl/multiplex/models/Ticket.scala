package pl.multiplex.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.{Entity, EnumType, Enumerated, GeneratedValue, GenerationType, Id, JoinColumn, ManyToOne}
import lombok.ToString

import scala.beans.BeanProperty

@Entity
class Ticket(@Enumerated(EnumType.STRING)
             @BeanProperty
             var ticketType: TicketType.Value) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @ManyToOne
  @JoinColumn(name = "user")
  @JsonBackReference
  @ToString.Exclude
  @BeanProperty
  var user: User = _
  @ManyToOne
  @JoinColumn(name = "user")
  @JsonBackReference
  @ToString.Exclude
  @BeanProperty
  var screening: Screening = _
}
