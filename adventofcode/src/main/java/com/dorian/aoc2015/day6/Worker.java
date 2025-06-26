package com.dorian.aoc2015.day6;

import java.util.*;
import org.apache.commons.lang3.tuple.Pair;

public class Worker {
  private Grid grid;
  List<Instruction> instructions;

  public Worker(List<Instruction> instructions) {
    this.grid = new Grid();
    this.instructions = instructions;
  }

  public Grid getGrid() {
    return grid;
  }

  public void followInstructions() {
    for (Instruction instruction : this.instructions) {
      int x1 = (int) instruction.getCoordinatesPair().getKey().getX();
      int y1 = (int) instruction.getCoordinatesPair().getKey().getY();

      int x2 = (int) instruction.getCoordinatesPair().getValue().getX();
      int y2 = (int) instruction.getCoordinatesPair().getValue().getY();

      for (int x = x1; x <= x2; x++) {
        Set<Pair<Integer, Integer>> processed = new HashSet<>();
        actOnLights(x, y1, instruction.getAction());
        processed.add(Pair.of(x, y1));
        for (int y = y1; y <= y2; y++) {
          if (!processed.contains(Pair.of(x, y))) {
            actOnLights(x, y, instruction.getAction());
          }
          processed.add(Pair.of(x, y));
        }
      }
    }
  }

  private void actOnLights(int x, int y, Action action) {
    Light currentLight = this.grid.getGrid()[x][y];
    switch (action) {
      case TOGGLE -> {
        currentLight.toggle();
      }
      case TURN_ON -> {
        currentLight.turnOn();
      }
      case TURN_OFF -> {
        currentLight.turnOff();
      }
    }
  }
}
