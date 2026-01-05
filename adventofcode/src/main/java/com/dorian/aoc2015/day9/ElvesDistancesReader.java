package com.dorian.aoc2015.day9;

import java.util.*;
import java.util.stream.Collectors;

public class ElvesDistancesReader {
  private final Set<Route> routes;
  // We keep a single instance of each Location to ensure .equals works simply
  private final Map<String, Location> locationRegistry;
  // Map of a Location to all Distances originating from it (Adjacency List)
  private final Map<Location, List<Distance>> adjacencyMap;

  public ElvesDistancesReader(List<String> rawDistances) {
    this.locationRegistry = new HashMap<>();
    this.adjacencyMap = new HashMap<>();

    // 1. Parse all data first
    for (String rawDistance : rawDistances) {
      processRawDistance(rawDistance);
    }

    // 2. Compute all valid complete routes
    this.routes = this.computeAllPossibleRoutes();
  }

  private void processRawDistance(String rawDistance) {
    // Parse "London to Dublin = 464"
    String[] parts = rawDistance.split(" ");
    String nameFrom = parts[0];
    String nameTo = parts[2];
    long distVal = Long.parseLong(parts[4]);

    Location from = locationRegistry.computeIfAbsent(nameFrom, Location::new);
    Location to = locationRegistry.computeIfAbsent(nameTo, Location::new);

    // IMPORTANT: The problem is an undirected graph.
    // If London -> Dublin is 464, then Dublin -> London is 464.
    // We must store BOTH directions to allow the route finder to move either way.
    addDistance(from, to, distVal);
    addDistance(to, from, distVal);
  }

  private void addDistance(Location from, Location to, long distVal) {
    Distance d = new Distance(from, to, distVal);
    adjacencyMap.computeIfAbsent(from, k -> new ArrayList<>()).add(d);
  }

  private Set<Route> computeAllPossibleRoutes() {
    Set<Route> foundRoutes = new HashSet<>();
    Collection<Location> allLocations = locationRegistry.values();

    for (Location startLocation : allLocations) {
      LinkedHashSet<Distance> currentPath = new LinkedHashSet<>();
      Set<Location> visited = new HashSet<>();
      visited.add(startLocation);

      searchRecursively(startLocation, visited, currentPath, foundRoutes, allLocations.size());
    }
    return foundRoutes;
  }

  private void searchRecursively(Location currentLocation,
                                 Set<Location> visited,
                                 LinkedHashSet<Distance> currentPath,
                                 Set<Route> foundRoutes,
                                 int targetSize) {

    if (visited.size() == targetSize) {
      // we found a complete route
      foundRoutes.add(new Route(new LinkedHashSet<>(currentPath)));
      return;
    }

    List<Distance> possibleNextSteps = adjacencyMap.getOrDefault(currentLocation, Collections.emptyList());

    for (Distance nextStep : possibleNextSteps) {
      Location nextLoc = nextStep.arrival();

      if (!visited.contains(nextLoc)) {

        Set<Location> newVisited = new HashSet<>(visited);
        newVisited.add(nextLoc);

        LinkedHashSet<Distance> newPath = new LinkedHashSet<>(currentPath);
        newPath.add(nextStep);

        searchRecursively(nextLoc, newVisited, newPath, foundRoutes, targetSize);
      }
    }
  }

  public Route getShortestRoute() {
    return routes.stream()
            .min(Comparator.comparingLong(Route::getTotalDistance))
            .orElseThrow(() -> new IllegalStateException("No routes found!"));
  }

  public Route getLongestRoute() {
    return routes.stream()
            .max(Comparator.comparingLong(Route::getTotalDistance))
            .orElseThrow(() -> new IllegalStateException("No routes found!"));
  }

  public Set<Route> getRoutes() {
    return routes;
  }
}