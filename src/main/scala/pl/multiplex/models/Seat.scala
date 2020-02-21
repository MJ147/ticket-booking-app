package pl.multiplex.models

import pl.multiplex.utils.NumbersToAlphabetConverter

class Seat(
            val rowNumber: Int,
            val numberInRow: Int,
            private var availability: Boolean = true,
            private var converter: NumbersToAlphabetConverter = new NumbersToAlphabetConverter
          ) {

  override def toString = s"rząd: ${converter.convertToLetters(rowNumber)}, miejsce: $numberInRow"
}
