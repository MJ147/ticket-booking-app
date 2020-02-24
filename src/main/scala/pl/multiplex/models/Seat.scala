package pl.multiplex.models

import pl.multiplex.utils.NumbersToAlphabetConverter

class Seat(
            val rowNumber: Int,
            val numberInRow: Int,
            private var isFree: Boolean = true,
            private var converter: NumbersToAlphabetConverter = new NumbersToAlphabetConverter
          ) {

  def setIsFree(isFree: Boolean): Unit = {
    this.isFree = isFree
  }

  def getIsFree(): Boolean = {
    isFree
  }

  override def toString = s"${converter.convertToLetters(rowNumber)}$numberInRow"
}


