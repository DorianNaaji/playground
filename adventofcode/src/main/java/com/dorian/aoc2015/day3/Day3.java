package com.dorian.aoc2015.day3;

import com.dorian.common.Day;
import com.dorian.common.utils.AocFileLoader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

// How many houses receive at least one present
public class Day3 implements Day {

  @Override
  public void start() {
    Logger logger = Logger.getLogger(this.getClass().getName());
    try {
      String directionsStr = AocFileLoader.readStringFromResources("aoc2015/day3.txt");
      char[] directions = directionsStr.toCharArray();
      Santa santa = new Santa();
      RoboSanta roboSanta = new RoboSanta();

      for (int i = 0; i < directions.length; i++) {
        CardinalDirection direction = CardinalDirection.fromAngleBracket(directions[i]);
        if (i % 2 == 0) {
          santa.move(direction);
        } else {
          roboSanta.move(direction);
        }
      }

      logger.log(Level.INFO, "Santa visited {0} houses", santa.getMap().getVisitedHouses().size());
      logger.log(
          Level.INFO,
          "Robo-Santa visited {0} houses",
          roboSanta.getMap().getVisitedHouses().size());
      logger.log(
          Level.INFO,
          "Santa & Robo-Santa visited {0} unique houses",
          Santa.getUniqueVisitedHouses(santa, roboSanta));

    } catch (URISyntaxException e) {
      logger.log(Level.SEVERE, "Malformed file path", e);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Malformed input file", e);
    }
  }
}
