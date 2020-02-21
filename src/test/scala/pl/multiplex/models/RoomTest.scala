package pl.multiplex.models

import org.scalatest.flatspec.AnyFlatSpec


class RoomTest extends AnyFlatSpec{

  var room: Room = _

  "createSeats method with correct rowNumber and seatNumberInRow" should "create seats" in  {
    room = new Room(rowsNumber = 5, seatsNumberInRow = 10)
    assert(room.seats(38).toString === "rząd: D, miejsce: 9")
  }


  "createSeatsMethod with incorrect RowNumber" should "produce Exception" in {
    assertThrows[IllegalArgumentException] {
      new Room(rowsNumber = -5, seatsNumberInRow = 10)
    }

  }


}
