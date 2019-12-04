package days.controllers;

import days.controllers.helpers.DayController;
import factorys.DayFileReader;
import models.FuelCalculator;

public class Day1Controller extends DayController<Integer, Integer> {
  private FuelCalculator fuelCalculator = new FuelCalculator();

  public Day1Controller(String filePath) {
    super(filePath);
  }

  @Override
  public void run() {
    System.out.println("Part one: " + solutionPartOne() + " [V]");
    System.out.println("Part two: " + solutionPartTwo() + " [V]");
  }

  @Override
  public Integer solutionPartOne() {
    return fuelCalculator.calcModuleFuelFromList(new DayFileReader().fileToIntegerList(FILEPATH, "\\s+"));
  }

  @Override
  public Integer solutionPartTwo() {
    return fuelCalculator.calcTotalFuelRequired(new DayFileReader().fileToIntegerList(FILEPATH, "\\s+"));
  }
}
