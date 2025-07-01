package com.dorian.aoc2015.day7;

import com.dorian.common.Day;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;

public class Day7 implements Day {
  @Override
  public void start() {
    try {
      Bobby bobby = new Bobby();
      bobby.assembleCircuit();

      for (Wire output :
          bobby.getCircuit().gateOperations().stream()
              .map(GateOperation::output)
              .distinct()
              .sorted(Comparator.comparing(Wire::getId))
              .toList()) {
        System.out.println(output.getId() + ": " + (output.getSignal() & 0xFFFF));
      }

    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
