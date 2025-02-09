package com.dorian.aoc2015.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Building {
  private final List<Floor> floors = new ArrayList<Floor>();

  public void addFloor(Floor floor) {
    floors.add(floor);
  }

  public Optional<Floor> findFloor(int level) {
    return floors.stream().filter(floor -> floor.getLevel() == level)
            .findFirst();
  }
}
