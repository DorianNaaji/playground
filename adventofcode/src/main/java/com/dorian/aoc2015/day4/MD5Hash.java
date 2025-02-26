package com.dorian.aoc2015.day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
  public static final String PREFIX = "iwrupvqb";
  private static final String FIVE_ZEROES = "00000";
  private final long trailingNumber;
  private final String md5HashValue;

  public MD5Hash(long trailingNumber) throws NoSuchAlgorithmException {
    this.trailingNumber = trailingNumber;
    this.md5HashValue = this.hash(PREFIX.concat(Long.toString(trailingNumber)));
  }

  public String getMd5HashValue() {
    return md5HashValue;
  }

  public long getTrailingNumber() {
    return trailingNumber;
  }

  public boolean hasFiveLeadingZeroes() {
    return this.md5HashValue.startsWith(FIVE_ZEROES);
  }

  private String hash(String input) throws NoSuchAlgorithmException {
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    md5.update(input.getBytes());
    return String.format("%032x", new BigInteger(1, md5.digest()));
  }
}
