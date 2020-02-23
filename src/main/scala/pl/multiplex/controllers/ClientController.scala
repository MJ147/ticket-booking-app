package pl.multiplex.controllers

import java.time.{LocalDate, LocalTime}

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}
import pl.multiplex.services.ScreeningService

@RequestMapping(Array("/client"))
@RestController
class ClientController(val screeningService: ScreeningService) {

  @GetMapping(Array("/find-screening"))
  def findAllByDateAndStartTimeBetween(@RequestParam date: String, @RequestParam startTime: String): ResponseEntity[java.util.List[Array[Any]]] = {
    ResponseEntity.ok().body(screeningService.findAllByDateAndStartTimeBetween(LocalDate.parse(date), LocalTime.parse(startTime)))
  }
}
