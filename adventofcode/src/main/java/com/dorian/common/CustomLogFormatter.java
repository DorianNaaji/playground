package com.dorian.common;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {
  private static final String RESET = "\u001B[0m";
  private static final String RED = "\u001B[31m";
  private static final String YELLOW = "\u001B[33m";
  private static final String BLUE = "\u001B[34m";
  private static final String FORMAT = "[%1$tc] %4$s: %5$s %n";

  @Override
  public String format(LogRecord record) {
    String color = RESET;

    if (record.getLevel() == Level.SEVERE) {
      color = RED;
    } else if (record.getLevel() == Level.WARNING) {
      color = YELLOW;
    } else if (record.getLevel() == Level.INFO) {
      color = BLUE;
    }

    String logMessage = String.format(
            FORMAT,
            new Date(record.getMillis()),         // %1$tc (Date)
            record.getSourceClassName(),          // %2$s (Source)
            record.getLoggerName(),               // %3$s (Logger name)
            record.getLevel().getLocalizedName(), // %4$s (Level)
            formatMessage(record),                // %5$s (Message)
            null                                  // %6$ (Exception)
    );

    return color + logMessage + RESET;
  }
}