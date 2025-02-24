package com.dorian.aoc2015.day2;

import java.io.IOException;
import java.util.List;

public class Elves {

  /**
   * Put elves at work to compute the square feet of wrapping paper they need.
   *
   * @return the total amount of required wrapping paper in square feet, computed from the sum of
   *     wrapping paper required for each PresentBox.
   */
  Answer computeAnswer(List<String> dimensions) throws IOException, ElfComputingException {
    List<PresentBox> presents = dimensions.stream().map(PresentBox::fromString).toList();
    Long requiredPaper =
        presents.stream().mapToLong(PresentBox::getRequiredPaperInSquareFeet).sum();
    Long requiredRibbonLength =
        presents.stream().mapToLong(PresentBox::getRequiredRibbonLength).sum();
    return new Answer(requiredPaper, requiredRibbonLength);
  }

  static class ElfComputingException extends Exception {}
}
