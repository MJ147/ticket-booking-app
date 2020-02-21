package pl.multiplex.models

import java.time.Duration

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.{Entity, EnumType, Enumerated, GeneratedValue, GenerationType, Id, MapsId, OneToOne}
import lombok.ToString

import scala.beans.BeanProperty

@Entity
class Movie(@BeanProperty
            @Enumerated(EnumType.STRING)
            val category: MovieCategory.Value,
            @BeanProperty
            val duration: Duration) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  @OneToOne
  @MapsId
  @JsonBackReference
  @ToString.Exclude
  @BeanProperty
  var screening: Screening = _

}
