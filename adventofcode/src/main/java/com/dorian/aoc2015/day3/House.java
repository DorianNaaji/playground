package com.dorian.aoc2015.day3;

public class House {
  private final Coordinates coordinates;
  private long timesVisited = 0;

  public House(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public void increaseTimesVisited() {
    this.timesVisited++;
  }

  public long getTimesVisited() {
    return timesVisited;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }
}
