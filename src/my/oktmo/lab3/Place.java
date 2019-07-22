package my.oktmo.lab3;

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
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Place that = (Place) obj;
    return code == that.code && status.equals(that.status) && name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Long.hashCode(code);
  }

  @Override
  public String toString() {
    return code + " " + status + " " + name;
  }

}
