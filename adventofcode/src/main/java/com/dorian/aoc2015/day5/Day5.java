package com.dorian.aoc2015.day5;

import com.dorian.common.Day;
import com.dorian.common.utils.AocFileLoader;
import java.io.IOException;
import java.net.URISyntaxException;

public class Day5 implements Day {
  @Override
  public void start() {
    try {
      Santa santa = new Santa(AocFileLoader.readLinesFromResources("aoc2015/day5.txt"));
      santa.sortNiceStrings();
      log("There are {0} nice strings", santa.getNiceStringsCount());
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
