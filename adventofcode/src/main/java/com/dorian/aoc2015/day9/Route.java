package com.dorian.aoc2015.day9;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Route {
  private final LinkedHashSet<Distance> distances;
  private final LinkedHashSet<Location> steps;
  private final long totalDistance;

  public Route(LinkedHashSet<Distance> distances) {
    this.distances = distances;
    this.steps = this.computeSteps();
    this.totalDistance = this.computeRouteDistance();
  }

  private LinkedHashSet<Location> computeSteps() {
    LinkedHashSet<Location> steps =  new LinkedHashSet<>();
    for(Distance distance: distances) {
      steps.add(distance.departure());
      steps.add(distance.arrival());
    }
    return steps;
  }

  private long computeRouteDistance() {
    return distances.stream().map(Distance::distance).mapToLong(Long::intValue).sum();
  }

  public long getTotalDistance() {
    return totalDistance;
  }

  @Override
  public String toString() {
    String joinedDistances = "";

    boolean first = true;

    for (Distance distance: distances) {
      if(first) {
        joinedDistances += distance.departure().name() + " -> " + distance.arrival().name();
        first = false;
        continue;
      }

      joinedDistances += " -> " + distance.arrival().name();
    }

    joinedDistances += " = " + totalDistance;

    return joinedDistances;
  }

  public LinkedHashSet<Location> getSteps() {
    return steps;
  }
}
