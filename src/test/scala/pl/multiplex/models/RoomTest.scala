package pl.multiplex.models

import org.scalatest.flatspec.AnyFlatSpec


class RoomTest extends AnyFlatSpec{

  var room: Room = new Room()

  "createSeats method with correct rowNumber and seatNumberInRow" should "create seats" in  {
    room.setRowsNumber(5)
    room.setSeatsNumberInRow(10)
    assert(room.getSeats()(38).toString === "rząd: D, miejsce: 9")
  }

  "createSeatsMethod with incorrect RowNumber" should "produce Exception" in {
    room.setRowsNumber(-5)
    room.setSeatsNumberInRow(10)
    assertThrows[IllegalArgumentException] {
      room.createSeats()
    }
  }
}
