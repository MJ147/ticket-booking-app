package pl.multiplex.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pl.multiplex.models.Ticket

@Repository
trait TicketDao extends CrudRepository[Ticket, Long]{

}
