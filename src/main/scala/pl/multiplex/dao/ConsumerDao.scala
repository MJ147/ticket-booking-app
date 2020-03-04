package pl.multiplex.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pl.multiplex.models.Consumer

@Repository
trait ConsumerDao extends CrudRepository[Consumer, Long] {

}
