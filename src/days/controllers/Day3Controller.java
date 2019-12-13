package days.controllers;

import days.controllers.helpers.DayController;
import factorys.DayFileReader;
import models.WiresPathCalculator;

public class Day3Controller extends DayController<Integer, Integer> {
  private WiresPathCalculator pathCalculator;

  public Day3Controller(String filePath) {
    super(filePath);
    pathCalculator = new WiresPathCalculator(new DayFileReader().fileToStringList(filePath, "\n"));
  }

  @Override
  public void run() {
    System.out.println("Part one: " + solutionPartOne() + " [V]");
    System.out.println("Part two: " + solutionPartTwo() + " [X]");
  }

  @Override
  public Integer solutionPartOne() {
    return pathCalculator.getClosestMatch();
  }

  @Override
  public Integer solutionPartTwo() {
    System.out.println("Not yet implemented");
    return null;
  }
}
