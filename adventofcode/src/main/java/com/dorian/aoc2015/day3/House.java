package com.dorian.aoc2015.day3;

import java.util.Objects;

public record House(Coordinates coordinates) {

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    House house = (House) o;
    return Objects.equals(coordinates, house.coordinates);
  }
}
