package my.oktmo;

import java.util.HashSet;

public class Place {
  private long code;
  private String status;
  private String name;

  public Place(long code, String status, String name) {
    this.code = code;
    this.status = status;
    this.name = name;
  }

  public long getCode() {
    return code;
  }

  public String getStatus() {
    return status;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return code + " " + status + " " + name;
  }
}
