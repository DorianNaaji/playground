package com.dorian.aoc2015.day1;

public enum Direction {
  UP,
  DOWN;

  public static Direction fromParenthesis(char parenthesis) {
    if (parenthesis == '(') {
      return UP;
    } else if (parenthesis == ')') {
      return DOWN;
    }

    throw new IllegalArgumentException(parenthesis + " is not a valid direction");
  }
}
