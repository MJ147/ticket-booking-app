package pl.multiplex.utils

class NumbersToAlphabetConverter () {

  val alphabet: String = "ABCDEFGHIJKLMNOPRSTUWYZ"

  def convertToLetters (number: Int ): Any = {
    number match {
      case (number: Int) if number < 0 =>
        throw new IllegalArgumentException("Numer rzędu nie może być ujemny")
      case (number: Int) if number <= alphabet.length =>
        alphabet.charAt(number-1)
      case _ =>
        s"Z${number - alphabet.length}" //if we are out of alphabet
    }

  }

}
