package pl.multiplex.exceptions

case class SeatAlreadyTakenException(private val message: String = "Miejsce jest już zajęte.") extends Exception(message) {

}
