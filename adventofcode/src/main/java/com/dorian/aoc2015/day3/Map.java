package com.dorian.aoc2015.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Map {
  private final List<House> visitedHouses = new ArrayList<>();
  private Coordinates currentCoordinatesOnMap = new Coordinates(0, 0);

  public List<House> getVisitedHouses() {
    return visitedHouses;
  }

  public void setCurrentCoordinatesOnMap(Coordinates currentCoordinatesOnMap) {
    this.currentCoordinatesOnMap = currentCoordinatesOnMap;
  }

  public Coordinates getCurrentCoordinatesOnMap() {
    return currentCoordinatesOnMap;
  }

  public void visitHouse(Coordinates coordinates) {
    if (this.visitedHouses.stream().anyMatch(house -> house.getCoordinates().equals(coordinates))) {
      throw new IllegalStateException(
          "There can't be two houses at the same location: " + coordinates.toString());
    }
    this.visitedHouses.add(new House(coordinates));
  }

  public Optional<House> findHouseByCoordinates(Coordinates coordinates) {
    return visitedHouses.stream()
        .filter(house -> house.getCoordinates().equals(coordinates))
        .findFirst();
  }
}
