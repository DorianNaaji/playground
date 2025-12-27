package com.dorian;

import com.dorian.aoc2015.day8.Day8;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class AdventOfCodePlayground {

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

  public static void main(String[] args) {
    new Day8().start();
  }
}
