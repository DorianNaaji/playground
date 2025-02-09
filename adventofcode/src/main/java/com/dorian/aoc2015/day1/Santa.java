package com.dorian.aoc2015.day1;

public class Santa {

  private final Building building;
  private Floor currentFloor;

  public Santa() {
    this.currentFloor = new Floor(0);
    this.building = new Building();
    this.building.addFloor(this.currentFloor);
  }

  public void act(char input) {
    Direction direction = Direction.fromParenthesis(input);

    if (direction == Direction.UP) {
      this.goUp();
    } else {
      this.goDown();
    }
  }

  public int getCurrentFloor() {
    return this.currentFloor.getLevel();
  }

  private void goUp() {
    this.go(this.currentFloor.getLevel() + 1);
  }

  private void goDown() {
    this.go(this.currentFloor.getLevel() - 1);
  }

  private void go(int level) {
    this.currentFloor = this.findOrCreateFloor(level);
  }

  private Floor findOrCreateFloor(int level) {
    return this.building.findFloor(level)
      .orElseGet(() -> {
        Floor newFloor = new Floor(level);
        this.building.addFloor(newFloor);
        return  newFloor;
      });
  }
}
