package com.dorian.aoc2015.day7;

import com.dorian.common.utils.AocFileLoader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;

public class InstructionsBooklet {

  Circuit initCircuit() throws IOException, URISyntaxException {
    List<GateOperation> gateOperations = new ArrayList<>();
    List<String> rawWires = AocFileLoader.readLinesFromResources("aoc2015/day7.txt");
    for (String rawWire : rawWires) {
      String[] parts = rawWire.split(" ");
      if (parts.length == 5) {
        String left = parts[0];
        String operation = parts[1];
        String right = parts[2];
        String output = parts[4];
        Gate gate = Gate.valueOf(operation);

        Wire leftWire = initWire(left);
        Wire rightWire = initWire(right);
        Wire outputWire = initWire(output);
        gateOperations.add(new GateOperation(gate, leftWire, rightWire, outputWire));

      }
      // NOT operation
      else if (parts.length == 4) {
        Wire right = new Wire().setId(parts[1]);
        Wire output = new Wire().setId(parts[3]);
        GateOperation operation = new GateOperation(Gate.NOT, null, right, output);

        gateOperations.add(operation);
      }
      // Primitive wire
      else if (parts.length == 3) {
        Wire right = initWire(parts[0]);
        Wire output = initWire(parts[2]);
        gateOperations.add(new GateOperation(null, null, right, output));
      }
    }

    this.synchronizeGates(gateOperations);
    this.synchronizeGates(gateOperations);

    return new Circuit(gateOperations);
  }

  // code smell
  private void synchronizeGates(List<GateOperation> gateOperations) {
    // Workaround du fait qu'on ne passe pas par une initialisation via dictionnaire/map
    // des wires et qu'on a des duplicates : on fait donc une comparaison un à un pour unifier
    // les instances...
    for (GateOperation g1 : gateOperations) {
      for (GateOperation g2 : gateOperations) {
        if (g1.left() != null && g1.left().equals(g2.left())) {
          g2.setLeft(g1.left());
        }

        if (g1.right() != null && g1.right().equals(g2.right())) {
          g2.setRight(g1.right());
        }

        if (g1.right() != null && g1.right().equals(g2.output())) {
          g2.setOutput(g1.right());
        }

        if (g1.left() != null && g1.left().equals(g2.output())) {
          g1.setLeft(g2.output());
        }

        if (g1.output() != null && g1.output().equals(g2.output())) {
          g2.setOutput(g1.output());
        }
      }
    }
  }

  private Wire initWire(String signalOrId) {
    Wire wire = new Wire();
    if (NumberUtils.isCreatable(signalOrId)) {
      wire.setSignal(Short.parseShort(signalOrId));
    } else {
      wire.setId(signalOrId);
    }
    return wire;
  }
}
