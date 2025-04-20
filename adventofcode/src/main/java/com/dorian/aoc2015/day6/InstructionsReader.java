package com.dorian.aoc2015.day6;

import java.util.ArrayList;
import java.util.List;

public class InstructionsReader {

  private List<String> rawInstructions;

  public InstructionsReader(List<String> rawInstructions) {
    this.rawInstructions = rawInstructions;
  }

  public List<Instruction> read() {
    List<Instruction> instructions = new ArrayList<>();
    // ex : turn on 158,270 through 243,802
    for (String rawInstruction : rawInstructions) {
      Action lightAction = null;
      if (rawInstruction.contains(Action.TURN_ON.getRawText())) {
        lightAction = Action.TURN_ON;
      } else if (rawInstruction.contains(Action.TURN_OFF.getRawText())) {
        lightAction = Action.TURN_OFF;
      } else if (rawInstruction.contains(Action.TOGGLE.getRawText())) {
        lightAction = Action.TOGGLE;
      }
      String cleanedUp = rawInstruction.replace(Action.TURN_ON.getRawText(), "");
      cleanedUp = cleanedUp.replace(Action.TURN_OFF.getRawText(), "");
      cleanedUp = cleanedUp.replace(Action.TOGGLE.getRawText(), "");
      cleanedUp = cleanedUp.replace("through", "");
      cleanedUp = cleanedUp.replace("  ", "|");
      cleanedUp = cleanedUp.trim();
      String[] coords = cleanedUp.split("\\|");
      String[] xy1 = coords[0].split(",");
      String[] xy2 = coords[1].split(",");
      Coordinates coordinates_xy1 = new Coordinates(Long.parseLong(xy1[0]), Long.parseLong(xy1[1]));
      Coordinates coordinates_xy2 = new Coordinates(Long.parseLong(xy2[0]), Long.parseLong(xy2[1]));

      instructions.add(new Instruction(lightAction, coordinates_xy1, coordinates_xy2));
    }
    return instructions;
  }
}
