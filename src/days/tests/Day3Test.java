package days.tests;

import days.tests.helpers.DayTestInterface;
import factorys.DayFileReader;
import models.WiresPathCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day3Test implements DayTestInterface {
  @Override
  @Test
  public void part_1_solution() {
    WiresPathCalculator pathCalculator = new WiresPathCalculator(new DayFileReader().fileToStringList(PATH_TO_FILE, "\n"));
    int distance = pathCalculator.getClosestMatch();
    Assert.assertEquals(1337, distance);
  }

  @Test
  public void part_1_first_example() {
    List<String> list = new ArrayList<>();
    String w1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
    String w2 = "U62,R66,U55,R34,D71,R55,D58,R83";
    list.add(w1);
    list.add(w2);

    WiresPathCalculator pathCalculator = new WiresPathCalculator(list);
    int distance = pathCalculator.getClosestMatch();
    Assert.assertEquals(159, distance);
  }


  @Test
  @Override
  public void part_2_solution() {}
  private static final String PATH_TO_FILE = "src/days/textFiles/day3.txt";
}