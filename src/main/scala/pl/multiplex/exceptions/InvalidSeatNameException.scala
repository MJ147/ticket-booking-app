package pl.multiplex.exceptions

case class InvalidSeatNameException(private val message: String = "Niepoprawny numer miejsca lub miejsce już zajęte.") extends Exception(message) {

}
