package pl.multiplex.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.{PostMapping, RequestMapping, RestController}
import pl.multiplex.utils.InitialDataHelper

@RestController
@RequestMapping(Array("/data"))
class DataController(initialDataHelper: InitialDataHelper) {

  @PostMapping(Array("/gen"))
  def findScreenings(): HttpStatus = {
    initialDataHelper.setFlagOnTakenSitsOnInitialApp
    HttpStatus.CREATED
  }

}
