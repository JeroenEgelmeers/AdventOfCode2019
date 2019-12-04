package days.controllers;

import days.controllers.helpers.DayController;
import days.controllers.helpers.DayControllerInterface;
import factorys.DayFileReader;
import models.FuelCalculator;

public class Day1Controller extends DayController implements DayControllerInterface<Integer> {
  private FuelCalculator fuelCalculator = new FuelCalculator();

  public Day1Controller(String filePath) {
    super(filePath);
  }

  @Override
  public void run() {
    System.out.println("Part one: " + solutionPartOne() + " [V]");
    System.out.println("Part two: " + solutionPartTwo() + " [V]");
  }

  public Integer solutionPartOne() {
    return fuelCalculator.calcModuleFuelFromList(new DayFileReader().fileToIntegerList(FILEPATH, "\\s+"));
  }

  public int solutionPartTwo() {
    return fuelCalculator.calcTotalFuelRequired(new DayFileReader().fileToIntegerList(FILEPATH, "\\s+"));
  }
}
