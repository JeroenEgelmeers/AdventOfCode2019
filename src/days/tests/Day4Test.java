package days.tests;

import days.controllers.Day4Controller;
import days.tests.helpers.DayTestInterface;
import models.SecureContainer;
import org.junit.Assert;
import org.junit.Test;

public class Day4Test implements DayTestInterface {
  @Override
  @Test
  public void part_1_solution() {
    Assert.assertEquals(931, (int)new Day4Controller("").solutionPartOne());
  }

  @Test
  public void part_1_first_example() {
    Assert.assertTrue(new SecureContainer().passwordIsValid(111111, new int[]{111110, 111112}));
  }

  @Test
  public void part_1_second_example() {
    Assert.assertFalse(new SecureContainer().passwordIsValid(223450, new int[]{223449, 223451}));
  }

  @Test
  public void part_1_third_example() {
    Assert.assertFalse(new SecureContainer().passwordIsValid(123789, new int[]{123788, 123790}));
  }

  @Override
  @Test
  public void part_2_solution() { }
}
