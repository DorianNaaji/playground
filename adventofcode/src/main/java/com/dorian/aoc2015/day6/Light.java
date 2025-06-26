package com.dorian.aoc2015.day6;

public class Light {
  private Coordinates coordinates;
  private int brightness;

  public Light(long posX, long posY) {
    this.coordinates = new Coordinates(posX, posY);
    this.brightness = 0;
  }

  public int getBrightness() {
    return this.brightness;
  }

  public void toggle() {
    this.brightness += 2;
  }

  public void turnOn() {
    this.brightness++;
  }

  public void turnOff() {
    if (this.brightness > 0) {
      this.brightness--;
    }
  }
}
