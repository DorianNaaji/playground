package com.dorian.aoc2015.day6;

import org.apache.commons.lang3.tuple.Pair;

public class Instruction {
  private Action action;
  private Pair<Coordinates, Coordinates> coordinatesPair;

  public Instruction(Action action, Coordinates xy1, Coordinates xy2) {
    this.action = action;
    this.coordinatesPair = Pair.of(xy1, xy2);
  }

  public Action getAction() {
    return action;
  }

  public Pair<Coordinates, Coordinates> getCoordinatesPair() {
    return coordinatesPair;
  }

  @Override
  public String toString() {
    return "Instruction{" + "action=" + action + ", coordinatesPair=" + coordinatesPair + '}';
  }
}
