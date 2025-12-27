package com.dorian.aoc2015.day8;

import com.dorian.common.Day;
import com.dorian.common.utils.AocFileLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

// Abandonned
public class Day8 implements Day {
  @Override
  public void start() {
    try {
      List<String> gifts = AocFileLoader.readLinesFromResources("aoc2015/day8.txt");
      int charactersOfCode = 0; // total string length
      int cptInMemory = 0; // cleanedGift

      for (String gift: gifts) {
        String giftTransformed = gift.substring(1, gift.length() - 1);
        giftTransformed = giftTransformed.replace("\\\"", "");
          giftTransformed = giftTransformed.replace("\\\\", "\\");
        giftTransformed = giftTransformed.replaceAll("\\\\x[0-9A-Fa-f]{2}", "!");

        charactersOfCode+= gift.length() + 2;
        cptInMemory+= giftTransformed.length();
        log("[{0}] ====> [{1}]", gift, giftTransformed);
      }

      log("Difference={0}", charactersOfCode - cptInMemory);
    } catch(IOException | URISyntaxException e) {
        throw new RuntimeException(e);
    }
  }
}
