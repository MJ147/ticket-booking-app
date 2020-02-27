package pl.multiplex.exceptions

case class InvalidFirstNameOrSecondNameException(private val message: String = "Niepoprawne imię lub nazwisko") extends Exception(message) {

}
