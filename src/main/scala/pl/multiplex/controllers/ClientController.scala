package pl.multiplex.controllers

import java.time.{LocalDate, LocalTime}

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestMapping, RequestParam, RestController}
import pl.multiplex.services.ScreeningService

@RequestMapping(Array("/client"))
@RestController
class ClientController(val screeningService: ScreeningService) {

  @GetMapping(Array("/find-screenings"))
  def findScreenings(@RequestParam date: String, @RequestParam startTime: String): ResponseEntity[java.util.List[Array[Any]]] = {
    ResponseEntity.ok().body(screeningService.findAllByDateAndStartTimeBetween(LocalDate.parse(date), LocalTime.parse(startTime)))
  }

  @GetMapping(Array("/get-screening"))
  def getScreening(@RequestParam title: String, @RequestParam date: String, @RequestParam time: String): ResponseEntity[String] = {
    ResponseEntity.ok.body(screeningService.findFirstByTitleAndDateAndStartTime(title, LocalDate.parse(date), LocalTime.parse(time)))
  }

}
