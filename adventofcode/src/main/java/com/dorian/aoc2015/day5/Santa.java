package com.dorian.aoc2015.day5;

import java.util.ArrayList;
import java.util.List;

public class Santa {

  public Santa(List<String> inputStrings) {
    this.santaStrings = inputStrings.stream().map(SantaString::new).toList();
  }

  private final List<SantaString> santaStrings;
  private final List<SantaString> niceStrings = new ArrayList<>();
  private final List<SantaString> naughtyStrings = new ArrayList<>();

  public void sortNiceStrings() {
    for (SantaString santaString : santaStrings) {
      if (santaString.isNice()) {
        niceStrings.add(santaString);
      } else {
        naughtyStrings.add(santaString);
      }
    }
  }

  public int getNiceStringsCount() {
    return this.niceStrings.size();
  }
}
