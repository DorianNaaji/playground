package com.dorian.aoc2015.day6;

public class Grid {
  Light[][] grid = new Light[1000][1000];

  public Grid() {
    for (int x = 0; x < grid.length; x++) {
      for (int y = 0; y < grid[x].length; y++) {
        grid[x][y] = new Light(x, y);
      }
    }
  }

  public Light[][] getGrid() {
    return grid;
  }

  public long countLit() {
    long lit = 0;
    for (int x = 0; x < grid.length; x++) {
      for (int y = 0; y < grid[x].length; y++) {
        if (grid[x][y].isLit()) {
          lit++;
        }
      }
    }
    return lit;
  }
}
