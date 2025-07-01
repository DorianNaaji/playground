package com.dorian.aoc2015.day7;

import java.util.List;
import java.util.Objects;

public class Circuit {

  private final List<GateOperation> gateOperations;

  public Circuit(List<GateOperation> gateOperations) {
    this.gateOperations = gateOperations;
  }

  public List<GateOperation> gateOperations() {
    return this.gateOperations;
  }

  public boolean hasNullOutputs() {
    return this.gateOperations.stream()
        .map(GateOperation::output)
        .map(Wire::getSignal)
        .anyMatch(Objects::isNull);
  }

  //  public List<Wire> wires() {
  //    return Stream.concat(
  //            this.gateOperations.stream().map(GateOperation::left).distinct(),
  //            this.gateOperations.stream().map(GateOperation::right).distinct()
  //    ).toList();
  //  }
}
