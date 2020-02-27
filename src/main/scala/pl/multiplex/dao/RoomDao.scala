package pl.multiplex.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pl.multiplex.models.{Room}

@Repository
trait RoomDao extends CrudRepository[Room, Long]{

}
