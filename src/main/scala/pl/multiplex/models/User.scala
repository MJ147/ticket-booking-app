package pl.multiplex.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id, OneToMany}

import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer

@Entity
class User(@BeanProperty
           val firstName: String,
           @BeanProperty
           val secondName: String,
           @BeanProperty
           val email: String) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @OneToMany(mappedBy = "user")
  @JsonManagedReference
  @BeanProperty
  var tickets: ListBuffer[Ticket] = new ListBuffer[Ticket]()
}
