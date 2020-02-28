package pl.multiplex.controllers

import java.time.{LocalDate, LocalTime}

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation._
import pl.multiplex.services.{ConsumerService, ScreeningService, TicketService}

@RequestMapping(Array("/client"))
@RestController
class ClientController(val screeningService: ScreeningService, val consumerService: ConsumerService, val ticketService: TicketService) {

  @GetMapping(Array("/find-screenings"))
  def findScreenings(@RequestParam date: String, @RequestParam startTime: String): ResponseEntity[java.util.List[Array[Any]]] = {
    ResponseEntity.ok().body(screeningService.findAllByDateAndStartTimeBetween(LocalDate.parse(date), LocalTime.parse(startTime)))
  }

  @GetMapping(Array("/get-screening"))
  def getScreening(@RequestParam title: String, @RequestParam date: String, @RequestParam time: String): ResponseEntity[String] = {
    ResponseEntity.ok.body(screeningService.findFirstByTitleAndDateAndStartTime(title, LocalDate.parse(date), LocalTime.parse(time)))
  }

  @PostMapping(Array("/create-tickets/{seatNumbers}/{ticketTypes}"))
  def createTickets(@RequestParam title: String, @RequestParam date: String, @RequestParam time: String, @RequestParam firstName: String, @RequestParam secondName: String,
                    @PathVariable seatNumbers: java.util.List[String], @PathVariable ticketTypes: java.util.List[String]): ResponseEntity[String] = {

    ResponseEntity.ok().body(ticketService.saveAll(title, LocalDate.parse(date), LocalTime.parse(time), firstName, secondName, seatNumbers, ticketTypes))
  }
}
