package com.dorian.aoc2015.day3;

import java.util.Optional;

// Starting point is 0.
public class Santa {
  private final Map map = new Map();
  private long distributedGifts = 0;

  public Map getMap() {
    return map;
  }

  public void move(CardinalDirection direction) {
    Coordinates currentCoordinates = map.getCurrentCoordinatesOnMap();
    Coordinates nextLocation = getNextLocation(direction, currentCoordinates);

    Optional<House> houseToVisit = this.map.findHouseByCoordinates(nextLocation);
    if (houseToVisit.isPresent()) {
      this.distributedGifts++;
      houseToVisit.get().increaseTimesVisited();
    } else {
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
