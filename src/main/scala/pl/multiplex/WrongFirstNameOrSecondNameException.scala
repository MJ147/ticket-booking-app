package pl.multiplex

case class WrongFirstNameOrSecondNameException(private val message: String = "Wrong first name or second name") extends Exception(message) {

}
