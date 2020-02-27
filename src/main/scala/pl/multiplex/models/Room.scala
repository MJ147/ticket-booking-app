package pl.multiplex.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence._

import scala.beans.BeanProperty

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

}
