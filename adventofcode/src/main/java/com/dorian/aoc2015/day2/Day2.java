package com.dorian.aoc2015.day2;

import com.dorian.common.Day;
import com.dorian.common.utils.AocFileLoader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day2 implements Day {
  @Override
  public void start() {
    final Logger logger = Logger.getLogger(this.getClass().getName());
    Elves elves = new Elves();
    try {
      List<String> dimensions = AocFileLoader.readFromResources("aoc2015/day2.txt");
      Answer answer = elves.computeAnswer(dimensions);
      logger.log(
          Level.INFO,
          "Elves require {0} square feet of wrapping paper",
          answer.getRequiredPaperInSquareFeet());
      logger.log(Level.INFO, "Elves require {0} feet of ribbon", answer.getRequiredRibbonLength());
    } catch (URISyntaxException e) {
      logger.log(Level.SEVERE, "Malformed file path", e);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Malformed input file", e);
    } catch (Elves.ElfComputingException e) {
      logger.log(Level.SEVERE, "Elf computing issue", e);
    }
  }
}
