package days.tests;

import days.controllers.Day3Controller;
import days.tests.helpers.DayTestInterface;
import models.WiresPathCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day3Test implements DayTestInterface {
  @Override
  @Test
  public void part_1_solution() {
    Integer distance = new Day3Controller(PATH_TO_FILE).solutionPartOne();
    Assert.assertEquals(1337, (int)distance);
  }

  @Test
  public void part_1_first_example() {
    List<String> list = new ArrayList<>();
    String w1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
    String w2 = "U62,R66,U55,R34,D71,R55,D58,R83";
    list.add(w1);
    list.add(w2);

    WiresPathCalculator pathCalculator = new WiresPathCalculator(list);
    int distance = pathCalculator.getClosestIntersectionPoint();
    Assert.assertEquals(159, distance);
  }

  @Test
  public void part_2_first_example() {
    List<String> list = new ArrayList<>();
    String w1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
    String w2 = "U62,R66,U55,R34,D71,R55,D58,R83";
    list.add(w1);
    list.add(w2);

    WiresPathCalculator pathCalculator = new WiresPathCalculator(list);
    int steps = pathCalculator.getFewestStepsToIntersectionPoint();

    Assert.assertEquals(610, steps);
  }

  @Test
  public void part_2_second_example() {
    List<String> list = new ArrayList<>();
    String w1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
    String w2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
    list.add(w1);
    list.add(w2);

    WiresPathCalculator pathCalculator = new WiresPathCalculator(list);
    int steps = pathCalculator.getFewestStepsToIntersectionPoint();
    Assert.assertEquals(410, steps);
  }

  @Test
  @Override
  public void part_2_solution() {
    Integer steps = new Day3Controller(PATH_TO_FILE).solutionPartTwo();
    Assert.assertEquals(65356, (int)steps);
  }

  private static final String PATH_TO_FILE = "src/days/textFiles/day3.txt";
}