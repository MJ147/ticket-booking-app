package pl.multiplex.models;

public enum TicketType {

  ADULT(25, "zł"),
  STUDENT(18, "zł"),
  CHILD(12.5, "zł");

  private double price;
  private String currency;

  TicketType(double price, String currency) {
    this.price = price;
    this.currency = currency;
  }


}


