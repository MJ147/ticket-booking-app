package pl.multiplex.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pl.multiplex.models.Movie

@Repository
trait MovieDao extends CrudRepository[Movie, Long] {


}
