package pl.multiplex.exceptions

case class SingleSeatLeftException(private val message: String = "Nie można pozostawić pojedynczego miejsca.") extends Exception(message) {

}
