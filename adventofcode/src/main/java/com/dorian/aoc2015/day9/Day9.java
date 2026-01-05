package com.dorian.aoc2015.day9;

import com.dorian.common.Day;
import com.dorian.common.utils.AocFileLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day9 implements Day {

  @Override
  public void start() {
    try {
      List<String> distances = AocFileLoader.readLinesFromResources("aoc2015/day9.txt");
      ElvesDistancesReader processor = new ElvesDistancesReader(distances);
      printAllPossibleRoutes(processor);
      log("Shortest route visiting all is : {0}", processor.getShortestRoute());
      log("Longest route visiting all is : {0}", processor.getLongestRoute());

    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  private void printAllPossibleRoutes(ElvesDistancesReader processor) {
    for (Route route: processor.getRoutes()) {
      log("{0}", route);
    }
  }
}
