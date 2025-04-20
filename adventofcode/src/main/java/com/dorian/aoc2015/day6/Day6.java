package com.dorian.aoc2015.day6;

import com.dorian.common.Day;
import com.dorian.common.utils.AocFileLoader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day6 implements Day {
  @Override
  public void start() {
    try {

      List<String> rawInstructions = AocFileLoader.readLinesFromResources("aoc2015/day6.txt");
      InstructionsReader reader = new InstructionsReader(rawInstructions);
      Worker worker = new Worker(reader.read());
      worker.followInstructions();
      // 1st result : 398967 => answer is too low
      log("{0} lights are lit", worker.getGrid().countLit());
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
