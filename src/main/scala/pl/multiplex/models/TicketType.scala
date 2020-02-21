package pl.multiplex.models

object TicketType extends Enumeration {

  val ADULT = TicketTypeVal(25, "zł")
  val STUDENT = TicketTypeVal(18, "zł")
  val CHILD = TicketTypeVal(12.5, "zł")

  protected case class TicketTypeVal(price: Double, currency: String) extends super.Val()
}
