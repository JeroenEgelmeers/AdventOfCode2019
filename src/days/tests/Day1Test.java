package days.tests;

import days.controllers.Day1Controller;
import days.tests.helpers.DayTestInterface;
import models.FuelCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Test implements DayTestInterface {

  // Part 1
  @Test
  public void part_1_mass_of_12_returns_2() { assertTotalFuelNeeded(12, 2); }
  @Test
  public void part_1_mass_of_14_returns_2() { assertTotalFuelNeeded(14, 2); }
  @Test
  public void part_1_mass_of_1969_returns_654() { assertTotalFuelNeeded(1969, 654); }
  @Test
  public void part_1_mass_of_100756_returns_33583() { assertTotalFuelNeeded(100756, 33583); }

  @Test
  public void part_1_mass_list() {
    List<Integer> massList = new ArrayList<>(Arrays.asList(12,14,1969,100756));
    assertTotalFuelRequired(massList, (2 + 2 + 654 + 33583));
  }

  @Test
  public void part_1_solution() { Assert.assertEquals(new Integer(3412094), new Day1Controller(PATH_TO_FILE).solutionPartOne()); }

  // part 2
  @Test
  public void part_2_mass_of_14_returns_2() { Assert.assertEquals(2, new FuelCalculator().calcRecursiveFuel(14)); }
  @Test
  public void part_2_mass_of_1969_returns_966() { Assert.assertEquals(966, new FuelCalculator().calcRecursiveFuel(1969)); }
  @Test
  public void part_2_mass_of_100756_returns_50346() { Assert.assertEquals(50346, new FuelCalculator().calcRecursiveFuel(100756));  }
  @Test
  public void part_2_solution() { Assert.assertEquals(new Integer(5115267), new Day1Controller(PATH_TO_FILE).solutionPartTwo()); }

  // assert methods
  private void assertTotalFuelNeeded(int mass, int expected) { Assert.assertEquals(expected, new FuelCalculator().calcModalFuel(mass)); }
  private void assertTotalFuelRequired(List<Integer> massList, int expected) { Assert.assertEquals(expected, new FuelCalculator().calcModuleFuelFromList(massList)); }

  public static final String PATH_TO_FILE = "../src/days/textFiles/day1.txt";
}
