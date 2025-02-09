package com.dorian.aoc2015.day1;

public enum Direction {
    UP(Consts.OPENING_PARENTHESIS),
    DOWN(Consts.CLOSING_PARENTHESIS);

    Direction(char parenthesis) {
        this.parenthesis = parenthesis;
    }

    private final char parenthesis;

    public char getParenthesis() {
        return parenthesis;
    }

    public static Direction fromParenthesis(char parenthesis) {
        if (parenthesis == Consts.OPENING_PARENTHESIS) {
            return UP;
        } else if (parenthesis == Consts.CLOSING_PARENTHESIS) {
            return DOWN;
        }

        throw new IllegalArgumentException(parenthesis + " is not a valid direction");
    }
}
