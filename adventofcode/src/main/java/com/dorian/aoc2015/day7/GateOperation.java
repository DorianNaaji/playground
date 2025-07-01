package com.dorian.aoc2015.day7;

import java.util.Objects;

// Shoulve use inheritance / interface
public class GateOperation {

  private Gate gate;
  private Wire left;
  private Wire right;
  private Wire output;

  public GateOperation(Gate gate, Wire left, Wire right, Wire output) {
    this.gate = gate;
    this.left = left;
    this.right = right;
    this.output = output;
  }

  public boolean isComputable() {
    if (this.gate != null && output.getSignal() == null) {
      switch (gate) {
        case AND, OR -> {
          return Wire.hasValue(left) && Wire.hasValue(right);
        }
        case LSHIFT, RSHIFT -> {
          return Wire.hasValue(left);
        }
        case NOT -> {
          return Wire.hasValue(right);
        }
        default -> {
          return false;
        }
      }
    }

    return false;
  }

  public Gate gate() {
    return gate;
  }

  public Wire left() {
    return left;
  }

  public void setLeft(Wire left) {
    this.left = left;
  }

  public Wire right() {
    return right;
  }

  public void setRight(Wire right) {
    this.right = right;
  }

  public Wire output() {
    return output;
  }

  public void setOutput(Wire output) {
    this.output = output;
  }

  @Override
  public String toString() {
    return "GateOperation{"
        + "gate="
        + gate
        + ", left="
        + left
        + ", right="
        + right
        + ", output="
        + output
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    GateOperation operation = (GateOperation) o;
    return gate == operation.gate
        && Objects.equals(left, operation.left)
        && Objects.equals(right, operation.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gate, left, right);
  }
}
