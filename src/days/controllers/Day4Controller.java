package days.controllers;

import days.controllers.helpers.DayController;
import models.SecureContainer;

public class Day4Controller  extends DayController<Integer, Integer> {
  private SecureContainer secureContainer;

  public Day4Controller(String filePath) {
    super(filePath);
    secureContainer = new SecureContainer();
  }

  @Override
  public void run() {
    System.out.println("Part one: " + solutionPartOne() + " [V]");
  }

  @Override
  public Integer solutionPartOne() {
    int[] range = {272091,815432};
    int i = range[0];
    int validPassword = 0;
    while(i < range[1]) {
      if (secureContainer.passwordIsValid(i, range)) { validPassword++; }
      i++;
    }

    return validPassword;
  }

  @Override
  public Integer solutionPartTwo() {
    return null;
  }
}
