package com.dorian.aoc2015.day6;

public enum Action {
  TURN_ON("turn on"),
  TURN_OFF("turn off"),
  TOGGLE("toggle");

  private final String rawText;

  public String getRawText() {
    return this.rawText;
  }

  Action(String rawText) {
    this.rawText = rawText;
  }

  @Override
  public String toString() {
    return "Action{" + "rawText='" + rawText + '\'' + '}';
  }
}
