package days.tests;

import days.controllers.Day2Controller;
import days.tests.helpers.DayTestInterface;
import models.OptCodeProgram;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2Test implements DayTestInterface {

  // Part 1
  @Test
  public void part_1_first_example_test() {
    List<Integer> testList = new ArrayList<>(Arrays.asList(1,0,0,0,99));
    Assert.assertEquals(Integer.valueOf(2), calculateProgram(testList));
  }

  @Test
  public void part_1_second_example_test() {
    List<Integer> testList = new ArrayList<>(Arrays.asList(2,3,0,3,99));
    Assert.assertEquals(Integer.valueOf(2), calculateProgram(testList));
  }

  @Test
  public void part_1_third_example_test() {
    List<Integer> testList = new ArrayList<>(Arrays.asList(2, 4, 4, 5, 99, 0));
    Assert.assertEquals(Integer.valueOf(2), calculateProgram(testList));
  }

  @Test
  public void part_1_fourth_example_test() {
    List<Integer> testList = new ArrayList<>(Arrays.asList(1,1,1,4,99,5,6,0,99));
    Assert.assertEquals(Integer.valueOf(30), calculateProgram(testList));
  }

  @Test
  public void part_1_solution() {
    Assert.assertEquals(Integer.valueOf(2782414), new Day2Controller(PATH_TO_FILE).solutionPartOne());
  }

  // Part 2
  @Test
  public void part_2_solution() {
    Assert.fail("Not yet implemented");
  }

  private Integer calculateProgram(List<Integer> testList) {
    OptCodeProgram optCodeProgram = new OptCodeProgram(testList);
    optCodeProgram.calculateProgram();

    return optCodeProgram.getProgram().get(0);
  }

  private static final String PATH_TO_FILE = "C:/Workspace/AdventOfCode/src/days/textFiles/day2.txt";
}
