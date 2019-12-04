package models;

import java.util.List;

public class FuelCalculator {
  public int calcModalFuel(int mass) {
    return Math.round(mass / 3) - 2;
  }

  public int calcRecursiveFuel(final int mass) {
    int total = 0;
    int massLeft = calcModalFuel(mass);
    while(massLeft > 0) {
      total += massLeft;
      massLeft = calcModalFuel(massLeft);
    }

    return total;
  }

  /*
  * Only calculate the fuel per module without recursion.
  * */
  public int calcModuleFuelFromList(List<Integer> massList) {
    int total = 0;

    for (Integer mass : massList) {
      total += calcModalFuel(mass);
    }

    return total;
  }

  /*
   * Calculate the Fuel with recursion (total).
   */
  public int calcTotalFuelRequired(List<Integer> massList) {
    int total = 0;

    for (Integer mass : massList) {
      total += calcRecursiveFuel(mass);
    }

    return total;
  }
}
