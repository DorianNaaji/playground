package com.dorian.aoc2015.day5;

import java.util.Arrays;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;

public class SantaString {
  protected final String value;
  private static final char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
  private static final String[] forbiddenStrings = new String[] {"ab", "cd", "pq", "xy"};

  protected SantaString(String value) {
    this.value = value;
  }

  public boolean isEvenNicer() {
    // https://www.reddit.com/r/adventofcode/comments/3viazx/comment/cxnxzd2/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button (I was stuck)
    Pattern appearsTwiceWithNoOverlapping = Pattern.compile("(..).*\\1");
    Pattern repeatsWithExactlyOneLetterInBetween = Pattern.compile("(.).\\1");
    return appearsTwiceWithNoOverlapping.matcher(this.value).find()
        && repeatsWithExactlyOneLetterInBetween.matcher(this.value).find();
  }

  public boolean isNice() {
    return this.containsThreeVowels()
        && this.containsTwoConsecutiveCharacter()
        && !this.containsForbiddenString();
  }

  private boolean containsThreeVowels() {
    int vowelCount = 0;
    for (char c : this.value.toCharArray()) {
      if (ArrayUtils.contains(vowels, c)) {
        vowelCount++;
      }
      if (vowelCount == 3) {
        return true;
      }
    }
    return false;

    // Commented out because this did filter for strings where there was 3+ occurences of the same
    // vowel only
    //    for(Character vowel: vowels) {
    //      int[] matches = IntStream.range(0, this.value.length())
    //              .filter(i -> this.value.charAt(i) == vowel)
    //              .toArray();
    //      if (matches.length >= 3) {
    //        return true;
    //      }
    //    }
    //    return false;
  }

  private boolean containsTwoConsecutiveCharacter() {
    char[] chars = this.value.toCharArray();
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] == chars[i + 1]) {
        return true;
      }
    }
    return false;
  }

  private boolean containsForbiddenString() {
    return Arrays.stream(forbiddenStrings).anyMatch(this.value::contains);
  }
}
