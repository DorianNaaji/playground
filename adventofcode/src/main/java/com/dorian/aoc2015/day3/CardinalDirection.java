package com.dorian.aoc2015.day3;

public enum CardinalDirection {
  NORTH,
  SOUTH,
  EAST,
  WEST;

  public static CardinalDirection fromAngleBracket(char angleBracket) {
    switch (angleBracket) {
      case '^' -> {
        return NORTH;
      }
      case 'v' -> {
        return SOUTH;
      }
      case '>' -> {
        return EAST;
      }
      case '<' -> {
        return WEST;
      }
      default -> throw new IllegalArgumentException("Character '" + angleBracket + "' is invalid.");
    }
  }
}
