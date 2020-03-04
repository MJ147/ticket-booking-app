package pl.multiplex.exceptions

case class NoSeatSelectedException(private val message: String = "Należy wybrać przynajmniej jedno miejsce.") extends Exception(message) {

}
