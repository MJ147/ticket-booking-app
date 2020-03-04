package pl.multiplex.models;

public enum TicketType {

  ADULT(25d, "zł"),
  STUDENT(18d, "zł"),
  CHILD(12.5, "zł");

  private Double price;
  private String currency;

  TicketType(Double price, String currency) {
    this.price = price;
    this.currency = currency;
  }

  public Double getPrice() {
    return price;
  }


}


