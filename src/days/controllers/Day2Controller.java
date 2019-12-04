package days.controllers;

import days.controllers.helpers.DayController;
import factorys.DayFileReader;
import models.IntCodeProgram;

import java.text.MessageFormat;

public class Day2Controller extends DayController<Integer, String> {
  private IntCodeProgram optCodeProgram;

  public Day2Controller(String filePath) {
    super(filePath);
    this.optCodeProgram = new IntCodeProgram(new DayFileReader().fileToIntegerList(filePath, ","));
  }

  @Override
  public void run() {
    System.out.println("Part one: " + solutionPartOne() + " [V]");
    System.out.println("Part two: " + solutionPartTwo() + " [V]");
  }

  @Override
  public Integer solutionPartOne() { return this.optCodeProgram.startProgramAndReturnOutputCode(); }

  @Override
  public String solutionPartTwo() {
    int[] output = partTwoOutput(19690720);
    return MessageFormat.format("the noun is {0}, the verb is {1}. The sum (100 & nuon + verb) is: {2}", output[0], output[1], (100*output[0]+output[1]));
  }

  public int[] partTwoOutput(int input) {
    return this.optCodeProgram.findOutput(input);
  }
}
