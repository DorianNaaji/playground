package com.dorian.aoc2015.day4;

import com.dorian.common.Day;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day4 implements Day {

  @Override
  public void start() {
    Logger logger = Logger.getLogger(this.getClass().getName());
    long trailingNumber = 1;
    try {
      MD5Hash hash = new MD5Hash(trailingNumber);
      while (!hash.hasFiveLeadingZeroes()) {
        hash = new MD5Hash(trailingNumber++);
      }

      long result = trailingNumber - 1;
      String input = MD5Hash.PREFIX.concat(Long.toString(result));
      logger.log(
          Level.INFO,
          "{0} hashes to {1} which has five leading zeroes.",
          new Object[] {input, hash.getMd5HashValue()});
      logger.log(Level.INFO, "Puzzle result is {0}", result);

    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
