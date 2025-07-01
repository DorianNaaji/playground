package com.dorian.aoc2015.day7;

import java.io.IOException;
import java.net.URISyntaxException;

public class Bobby {

  private final Circuit circuit;

  public Bobby() throws IOException, URISyntaxException {
    this.circuit = new InstructionsBooklet().initCircuit();
  }

  public void assembleCircuit() {
    while (circuit.hasNullOutputs()) {
      for (GateOperation operation : circuit.gateOperations()) {
        if (operation.gate() != null) {
          if (operation.isComputable()) {
            // Idée de pattern : L'enum ou le wire devrait contenir l'opération et on devrait juste
            // avoir une méthode "apply"
            switch (operation.gate()) {
              case AND ->
                  operation
                      .output()
                      .setSignal(
                          (short) (operation.left().getSignal() & operation.right().getSignal()));
              case OR ->
                  operation
                      .output()
                      .setSignal(
                          (short) (operation.left().getSignal() | operation.right().getSignal()));
              case LSHIFT ->
                  operation
                      .output()
                      .setSignal(
                          (short) (operation.left().getSignal() << operation.right().getSignal()));
              case RSHIFT ->
                  operation
                      .output()
                      .setSignal(
                          (short) (operation.left().getSignal() >> operation.right().getSignal()));
              case NOT -> operation.output().setSignal((short) (~operation.right().getSignal()));
            }
          }
        } else {
          operation.output().setSignal(operation.right().getSignal());
        }
      }
      System.out.println(
          "Computable gates: "
              + circuit.gateOperations().stream().filter(GateOperation::isComputable).count());
    }
  }

  public Circuit getCircuit() {
    return circuit;
  }
}
