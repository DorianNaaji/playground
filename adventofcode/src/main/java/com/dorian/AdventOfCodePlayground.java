package com.dorian;

import com.dorian.aoc2015.day8.Day8;
import com.dorian.aoc2015.day9.Day9;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class AdventOfCodePlayground {

  public static void main(String[] args) {
    new Day9().start();
  }

  static {
    final InputStream inputStream = Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream("logging.properties");
    try {
      LogManager.getLogManager().readConfiguration(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  } // Configure Logging
}
