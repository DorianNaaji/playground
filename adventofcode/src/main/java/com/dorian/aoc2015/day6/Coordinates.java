package com.dorian.aoc2015.day6;

public class Coordinates {
  private long x;
  private long y;

  public Coordinates(long x, long y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Coordinates{" + "x=" + x + ", y=" + y + '}';
  }

  public long getX() {
    return x;
  }

  public long getY() {
    return y;
  }
}
