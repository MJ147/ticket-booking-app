package pl.multiplex.models

import java.time.{LocalDate, LocalTime}

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id, OneToMany, OneToOne}

import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer

@Entity
class Screening(@BeanProperty
                val date: LocalDate,
                @BeanProperty
                val startTime: LocalTime) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @OneToMany(mappedBy = "screening")
  @JsonManagedReference
  @BeanProperty
  var tickets: ListBuffer[Ticket] = new ListBuffer[Ticket]()
  @OneToOne(mappedBy = "screening")
  @JsonManagedReference
  @BeanProperty
  var movie: Movie = _
  @OneToOne(mappedBy = "screening")
  @JsonManagedReference
  @BeanProperty
  var room: Room = _
}
