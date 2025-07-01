package com.dorian.aoc2015.day7;

import java.util.Objects;

public class Wire {
  private String id;
  private Short signal;

  public String getId() {
    return id;
  }

  public Wire setId(String id) {
    this.id = id;
    return this;
  }

  public Short getSignal() {
    return signal;
  }

  public void setSignal(Short signal) {
    this.signal = signal;
  }

  public static boolean hasValue(Wire wire) {
    return wire != null && wire.signal != null;
  }

  @Override
  public String toString() {
    return "Wire{" + "id='" + id + '\'' + ", signal=" + signal + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Wire wire = (Wire) o;
    return Objects.equals(id, wire.id) && Objects.equals(signal, wire.signal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, signal);
  }
}
