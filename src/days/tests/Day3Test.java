package days.tests;

import days.tests.helpers.DayTestInterface;
import factorys.DayFileReader;
import models.WiresPathCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3Test implements DayTestInterface {
  @Override
  @Test
  public void part_1_solution() {
    WiresPathCalculator pathCalculator = new WiresPathCalculator(22000, 22000, new DayFileReader().fileToStringList(PATH_TO_FILE, "\n"));
    int[] i = pathCalculator.getClosestMatch();
    int distance = pathCalculator.getDistanceToCentralPoint(i);
    System.out.println("Output is: " + i[0] + " " + i[1] + ". Distance: " + distance);
  }

  @Test
  @Override
  public void part_2_solution() {
    List<String> list = new ArrayList<>();
    String[] w1 = {"R75","D30","R83","U83","L12","D49","R71","U7","L72"};
    String[] w2 = {"U62","R66","U55","R34","D71","R55","D58","R83"};
    list.addAll(Arrays.asList(w1));
    list.addAll(Arrays.asList(w2));

    WiresPathCalculator pathCalculator = new WiresPathCalculator(10000, 10000, list);
    int[] i = pathCalculator.getClosestMatch();
    int distance = pathCalculator.getDistanceToCentralPoint(i);
    Assert.assertEquals(159, distance);
  }


  private static final String PATH_TO_FILE = "C:/Workspace/AdventOfCode2019/src/days/textFiles/day3.txt";
}