package days.controllers;

import days.controllers.helpers.DayController;
import factorys.DayFileReader;
import models.OptCodeProgram;

public class Day2Controller extends DayController<Integer> {
  private OptCodeProgram optCodeProgram;

  public Day2Controller(String filePath) {
    super(filePath);
    this.optCodeProgram = new OptCodeProgram(new DayFileReader().fileToIntegerList(filePath, ","));
  }

  @Override
  public void run() { System.out.println("Part one: " + solutionPartOne() + " [V]"); }

  @Override
  public Integer solutionPartOne() { return this.optCodeProgram.startProgramAndReturnOutputCode(); }

  @Override
  public Integer solutionPartTwo() {
    System.out.println("Not yet implemented");
    return null;
  }
}
