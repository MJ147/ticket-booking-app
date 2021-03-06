package pl.multiplex.models

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class Movie extends Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @BeanProperty
  var title: String = _
  @BeanProperty
  @Enumerated(EnumType.STRING)
  var category: MovieCategory = _
  @BeanProperty
  var duration: Int = _
}
