package my.oktmo;

public class Place {
  private long code;
  private String status;
  private String name;

  public Place(long code, String status, String name) {
    this.code = code;
    this.status = status;
    this.name = name;
  }

  @Override
  public String toString() {
    return code + " " + status + " " + name;
  }
}
