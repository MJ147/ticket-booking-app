package pl.multiplex.models

import java.time.{LocalDate, LocalTime}

import com.fasterxml.jackson.annotation.{JsonBackReference, JsonManagedReference}
import javax.persistence._
import lombok.ToString

import scala.beans.BeanProperty

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
}
