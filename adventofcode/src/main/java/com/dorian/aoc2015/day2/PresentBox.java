package com.dorian.aoc2015.day2;

import java.util.Arrays;

/**
 * Box dimensions are in feet.
 */
public class PresentBox {

  private final long length;
  private final long width;
  private final long height;

  private final long side1SurfaceArea;
  private final long side2SurfaceArea;
  private final long side3SurfaceArea;

  private final long smallestSideSurfaceArea;

  public PresentBox(long width, long length, long height) {
    this.width = width;
    this.length = length;
    this.height = height;

    this.side1SurfaceArea = this.length * this.width;
    this.side2SurfaceArea = this.width  * this.height;
    this.side3SurfaceArea = this.height * this.length;

    this.smallestSideSurfaceArea = Math.min(Math.min(this.side1SurfaceArea, this.side2SurfaceArea), this.side3SurfaceArea);
  }


  /**
   * Constructs a presentBox from a string like "6x2x4".
   */
  public static PresentBox fromString(String dimensionsAsString) {
    long[] dimensions = Arrays.stream(dimensionsAsString.split("x")).mapToLong(Long::parseLong).toArray();
    assert dimensions.length == 3 : "Incorrectly formed dimensions. Use 'wxlxh' format";
    return new PresentBox(dimensions[0], dimensions[1], dimensions[2]);
  }

  /**
   * Amount of required paper in square feet is computed with
   * the surface of the present box PLUS the smallest side.
   * @return the required amount of paper to wrap the present box, in square feet.
   */
  public long getRequiredPaperInSquareFeet() {
    return this.getSurfaceArea() + this.getSmallestSideSurfaceArea();
  }

  /**
   * Length of ribbon required : shortest distance around its sides to wrap
   * AND cubic volume to make a bow.
   * @return the required ribbon length in feet
   */
  public long getRequiredRibbonLength() {
    return this.getSmallestPerimeter() + this.getCubicFeet();
  }

  private long getSurfaceArea() {
    return (2 * this.side1SurfaceArea) + (2 * this.side2SurfaceArea) + (2 * this.side3SurfaceArea);
  }

  private long getCubicFeet() {
    return this.length * this.width * this.height;
  }

  private long getSmallestSideSurfaceArea() {
    return this.smallestSideSurfaceArea;
  }

  private long getSmallestPerimeter() {
    long perimeter1 = 2 * (this.length + this.width);
    long perimeter2 = 2 * (this.width + this.height);
    long perimeter3 = 2 * (this.height + this.length);
    return Math.min(Math.min(perimeter1, perimeter2), perimeter3);

    /* Alternative option : Smallest distance around its side
    long[] unordered = new long[]{this.width, this.length, this.height};
    long[] sorted = Arrays.stream(unordered).sorted().toArray();
    long smallestPerimeter = sorted[0] * 2;
    long secondSmallestPerimeter = sorted[1] * 2;

    return smallestPerimeter + secondSmallestPerimeter;
     */
  }
}
