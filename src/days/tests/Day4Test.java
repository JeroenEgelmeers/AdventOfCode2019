package days.tests;

import days.controllers.Day4Controller;
import days.tests.helpers.DayTestInterface;
import models.SecureContainer;
import org.junit.Assert;
import org.junit.Test;

public class Day4Test implements DayTestInterface {
  /** Part one **/
  @Override
  @Test
  public void part_1_solution() { Assert.assertEquals(931, (int)new Day4Controller("").solutionPartOne()); }

  @Test
  public void part_1_first_example() {
    Assert.assertTrue(new SecureContainer().passwordIsValid(111111, new int[]{111110, 111112}, false));
  }

  /**
   * Does not meet the requirement to have numbers that follow each other up. 0 is before 5.
   */
  @Test
  public void part_1_second_example() {
    Assert.assertFalse(new SecureContainer().passwordIsValid(223450, new int[]{223449, 223451}, false));
  }

  /**
   * Does not meet the requirement to have two equal numbers after each other.
   */
  @Test
  public void part_1_third_example() {
    Assert.assertFalse(new SecureContainer().passwordIsValid(123789, new int[]{123788, 123790}, false));
  }

  /** Part two **/
  @Override
  @Test
  public void part_2_solution() { Assert.assertEquals(609, (int)new Day4Controller("").solutionPartTwo()); }

  @Test
  public void part_2_first_example() {
    Assert.assertTrue(new SecureContainer().passwordIsValid(112233, new int[]{112232, 112234}, true));
  }

  /**
   * Should fail as there is 3 times a 4. Should be 4 times then. (3 % 2 = odd, should be even).
   */
  @Test
  public void part_2_second_example() {
    Assert.assertFalse(new SecureContainer().passwordIsValid(123444, new int[]{123443, 123445}, true));
  }

  /**
   * Should succeed as it contains 4 times a 1 (grouped and 4 % 2 = even number).
   */
  @Test
  public void part_2_third_example() {
    Assert.assertTrue(new SecureContainer().passwordIsValid(111122, new int[]{111121, 111123}, true));
  }
}
