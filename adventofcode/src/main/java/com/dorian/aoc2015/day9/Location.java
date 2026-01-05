package com.dorian.aoc2015.day9;

import java.util.Objects;

public record Location(String name) {
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Location location1 = (Location) o;
    return Objects.equals(name, location1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
