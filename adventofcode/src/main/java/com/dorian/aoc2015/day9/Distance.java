package com.dorian.aoc2015.day9;

public record Distance(Location departure, Location arrival, long distance) {

  @Override
  public String toString() {
    return "Distance{" +
            "departure=" + departure +
            ", arrival=" + arrival +
            '}';
  }
}
