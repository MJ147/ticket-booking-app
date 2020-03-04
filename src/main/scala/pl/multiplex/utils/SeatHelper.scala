package pl.multiplex.utils

import pl.multiplex.exceptions.{NoSeatSelectedException, SeatAlreadyTakenException, SingleSeatLeftException}
import pl.multiplex.models.{Screening, Seat}

class SeatHelper(val seatNumbers: java.util.List[String], val screening: Screening) extends Serializable() {

  @throws(classOf[NoSeatSelectedException])
  @throws(classOf[IndexOutOfBoundsException])
  @throws(classOf[SeatAlreadyTakenException])
  @throws(classOf[SingleSeatLeftException])
  def isSeatNamesAreCorrect(): Boolean = {
    if (seatNumbers.isEmpty) {
      throw NoSeatSelectedException()
    }
    var seat: Seat = null
    for (i <- 0 until seatNumbers.size()) {
      seat = screening.getSeats().filter(s => s.toString.equals(seatNumbers.get(i)))(0)
      if (!seat.getIsFree()) {
        throw SeatAlreadyTakenException()
      }
      if (isSingleSeatLeft(seat)) {
        throw SingleSeatLeftException()
      }
    }
    true
  }

  private def isSingleSeatLeft(seat: Seat): Boolean = {
    var isSingleSeatLeft: Boolean = false
    if (!isNextSeatIsFree(seat, -2) || seatNumbers.contains(convertToOtherSeatInTheSameRow(seat, -2).toString)) {
      if (isNextSeatIsFree(seat, -1) && !seatNumbers.contains(convertToOtherSeatInTheSameRow(seat, -1).toString)) {
        isSingleSeatLeft = true
      }
    }
    if (!isNextSeatIsFree(seat, 2) || seatNumbers.contains(convertToOtherSeatInTheSameRow(seat, 2).toString)) {
      if (isNextSeatIsFree(seat, 1) && !seatNumbers.contains(convertToOtherSeatInTheSameRow(seat, 1).toString)) {
        isSingleSeatLeft = true
      }
    }
    isSingleSeatLeft
  }

  private def isNextSeatIsFree(seat: Seat, plusOrMinusValue: Int): Boolean = {
    val newSeat = convertToOtherSeatInTheSameRow(seat, plusOrMinusValue)
    if (newSeat == null) {
      return false
    }
    newSeat.getIsFree()
  }

  private def convertToOtherSeatInTheSameRow(seat: Seat, plusOrMinusValue: Int): Seat = {
    val row = seat.toString.charAt(0)
    val numberInRow = seat.numberInRow + plusOrMinusValue
    if (numberInRow < 1 || numberInRow > screening.room.getSeatsNumberInRow) {
      return null
    }
    convertSeatNumberToSeatObject(row.toString + numberInRow)
  }

  private def convertSeatNumberToSeatObject(seatNumber: String): Seat = {
    screening.getSeats().filter(s => s.toString.equals(seatNumber))(0)
  }


}
