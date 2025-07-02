package com.dorian.aoc2015.day7;

import com.dorian.common.Day;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

// https://www.reddit.com/r/adventofcode/comments/3vr4m4/day_7_solutions/ 😥
public class Correction implements Day {

  @Override
  public void start() {

    ops = new HashMap<>();
    ops.put("AND", (a, b) -> a & b);
    ops.put("OR", (a, b) -> a | b);
    ops.put("LSHIFT", (a, b) -> a << b);
    ops.put("RSHIFT", (a, b) -> a >> b);

    vars = new HashMap<>();

    Scanner s = null;
    InputStream is = getClass().getClassLoader().getResourceAsStream("aoc2015/day7.txt");
    s = new Scanner(is);

    while (s.hasNextLine()) {
      String line = s.nextLine();
      String[] split = line.split(" ");

      Node var = new Node();
      if (split.length == 3) {
        var.setValue(getValue(split[0]));
        vars.put(split[2], var);
      } else if (split[0].equals("NOT")) {
        var.setValue(new Negation(getValue(split[1])));
        vars.put(split[3], var);
      } else {
        var.setValue(new Operator(split[1], getValue(split[0]), getValue(split[2])));
        vars.put(split[4], var);
      }
    }

    // pre calculated value for part 2
    vars.get("b").setValue(new Literal(16076));

    System.out.println(vars.get("a").getValue());
  }

  static HashMap<String, IntBinaryOperator> ops;
  static HashMap<String, Node> vars;

  static Element getValue(String s) {
    if (s.matches("\\d+")) {
      return new Literal(Integer.parseInt(s));
    } else {
      return new LazyNode(s);
    }
  }

  interface Element {
    int getValue();
  }

  static class Node implements Element {
    Element value;
    Integer cached = null;

    public void setValue(Element value) {
      this.value = value;
    }

    @Override
    public int getValue() {
      if (cached == null) cached = value.getValue() & 0xffff;
      return cached;
    }
  }

  static class LazyNode implements Element {
    String name;

    public LazyNode(String name) {
      this.name = name;
    }

    @Override
    public int getValue() {
      return vars.get(name).getValue();
    }
  }

  static class Literal implements Element {
    int value;

    public Literal(int value) {
      this.value = value;
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  static class Negation implements Element {
    Element orig;

    public Negation(Element orig) {
      this.orig = orig;
    }

    @Override
    public int getValue() {
      return ~orig.getValue();
    }
  }

  static class Operator implements Element {
    IntBinaryOperator op;
    String title;
    Element left, right;

    public Operator(String title, Element left, Element right) {
      this.title = title;
      op = ops.get(title);
      this.left = left;
      this.right = right;
    }

    @Override
    public int getValue() {
      return op.applyAsInt(left.getValue(), right.getValue());
    }
  }
}
