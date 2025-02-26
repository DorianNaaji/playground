package com.dorian.aoc2015.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Starting point is 0.
public class Santa {
  protected final Map map = new Map();

  /** Computes the unique houses that were visited by two Santas */
  public static long getUniqueVisitedHouses(Santa santa1, Santa santa2) {
    List<House> union = new ArrayList<>(santa1.getMap().getVisitedHouses());
    for (House house : santa2.getMap().getVisitedHouses()) {
      if (!union.contains(house)) {
        union.add(house);
      }
    }
    return union.size();
  }

  public Map getMap() {
    return map;
  }

  public void move(CardinalDirection direction) {
    Coordinates currentCoordinates = map.getCurrentCoordinatesOnMap();
    Coordinates nextLocation = getNextLocation(direction, currentCoordinates);
    Optional<House> houseToVisit = this.map.findHouseByCoordinates(nextLocation);
    if (houseToVisit.isEmpty()) {
      this.map.visitHouse(nextLocation);
    }

    this.map.setCurrentCoordinatesOnMap(nextLocation);
  }

  private Coordinates getNextLocation(CardinalDirection direction, Coordinates currentCoordinates) {
    Coordinates nextLocation = null;
    switch (direction) {
      case NORTH ->
          nextLocation = new Coordinates(currentCoordinates.getX(), currentCoordinates.getY() + 1);
      case SOUTH ->
          nextLocation = new Coordinates(currentCoordinates.getX(), currentCoordinates.getY() - 1);
      case EAST ->
          nextLocation = new Coordinates(currentCoordinates.getX() + 1, currentCoordinates.getY());
      case WEST ->
          nextLocation = new Coordinates(currentCoordinates.getX() - 1, currentCoordinates.getY());
    }
    return nextLocation;
  }
}
