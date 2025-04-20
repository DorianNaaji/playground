package com.dorian.aoc2015.day6;

public class Light {
  private Coordinates coordinates;
  private boolean lit;

  public Light(long posX, long posY) {
    this.coordinates = new Coordinates(posX, posY);
    this.lit = false;
  }

  public boolean isLit() {
    return lit;
  }

  public void turnOn() {
    this.lit = true;
  }

  public void turnOff() {
    this.lit = false;
  }
}
