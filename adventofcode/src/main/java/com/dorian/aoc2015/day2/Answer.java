package com.dorian.aoc2015.day2;

public class Answer {
  private final Long requiredPaperInSquareFeet;
  private final Long requiredRibbonLength;

  public Answer(Long requiredPaperInSquareFeet, Long requiredRibbonLength) {
    this.requiredPaperInSquareFeet = requiredPaperInSquareFeet;
    this.requiredRibbonLength = requiredRibbonLength;
  }

  public Long getRequiredPaperInSquareFeet() {
    return requiredPaperInSquareFeet;
  }

  public Long getRequiredRibbonLength() {
    return requiredRibbonLength;
  }
}
