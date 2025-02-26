package com.dorian.common;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Day {
  void start();

  default void log(String message, Object[] objects) {
    Logger.getLogger("AdventOfCode").log(Level.INFO, message, objects);
  }

  default void log(String message, Object object) {
    Logger.getLogger("AdventOfCode").log(Level.INFO, message, object);
  }
}
