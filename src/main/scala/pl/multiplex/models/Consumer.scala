package pl.multiplex.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence._

import scala.beans.BeanProperty

@Entity
class Consumer extends Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @BeanProperty
  var firstName: String = _
  @BeanProperty
  var secondName: String = _
  @OneToMany(mappedBy = "consumer")
  @JsonBackReference
  @BeanProperty
  var tickets: java.util.List[Ticket] = new java.util.ArrayList[Ticket]()

}
