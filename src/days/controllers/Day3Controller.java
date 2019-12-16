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
    System.out.println("Part two: " + solutionPartTwo() + " [V]");
  }

  @Override
  public Integer solutionPartOne() { return pathCalculator.getClosestIntersectionPoint(); }

  @Override
  public Integer solutionPartTwo() {
    return pathCalculator.getFewestStepsToIntersectionPoint();
  }
}
