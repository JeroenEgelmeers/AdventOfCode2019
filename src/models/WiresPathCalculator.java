package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WiresPathCalculator {
  private String wireOne;
  private String wireTwo;
  private int centralPointX = 0;
  private int centralPointY = 0;

  private HashMap<Integer, HashMap<Integer, String>> grid = new HashMap();
  private List<int[]> intersectionPoints;

  public WiresPathCalculator(List<String> wires) {
    this.intersectionPoints = new ArrayList<>();
    this.wireOne = wires.get(0).replaceAll("(\\r|\\n)", "");
    this.wireTwo = wires.get(1).replaceAll("(\\r|\\n)", "");
    renderWireInGrid(Arrays.asList(this.wireOne.split(",")), "A");
    renderWireInGrid(Arrays.asList(this.wireTwo.split(",")), "B");
  }

  private void renderWireInGrid(List<String> wire, String wireName) {
    int[] currentPos = { centralPointX, centralPointY };
    for(String position : wire) {
      currentPos = wireAction(position, wireName, currentPos);
    }
  }

  // TODO: Better name; get closest point from central point where wires hit eachother.
  public int getClosestMatch() {
    int closest = Integer.MAX_VALUE;
    for(int[] iPoint : this.intersectionPoints) {
       int distance = getDistanceToCentralPoint(iPoint);
       if (distance < closest ) {
         closest = distance;
       }
    }

    return closest;
  }

  public int getDistanceToCentralPoint(int[] iPoint) {
    return Math.abs(iPoint[0] - this.centralPointX) + Math.abs(iPoint[1] - this.centralPointY);
  }

  private int[] wireAction(String action, String wireName, int[] currentPos) {
    int currentX = currentPos[0];
    int currentY = currentPos[1];

    int steps = 0;
    try {
       steps = Integer.parseInt(action.substring(1));
      }catch(NumberFormatException e) {
        System.out.println(e);
      }

      switch(action.charAt(0)) {
        case 'R':
          for(int i = currentX + 1; i < currentX + (steps - 1); i++) { updateGrid(i, currentY, wireName); }
          updateGrid(currentX + steps, currentY, "+");
          return new int[]{currentX + steps, currentY};
        case 'U':
          for(int i = currentY + 1; i < currentY + (steps - 1); i++) { updateGrid(currentX, i, wireName); }
          updateGrid(currentX, currentY + steps, "+");
          return new int[]{currentX, currentY + steps};
        case 'L':
          for(int i = currentX - 1; i > currentX - (steps - 1); i--) { updateGrid(i, currentY, wireName); }
          updateGrid(currentX - steps, currentY, "+");
          return new int[]{currentX - steps, currentY};
        case 'D':
          for(int i = currentY - 1; i > currentY  - (steps - 1); i--) { updateGrid(currentX, i, wireName); }
          updateGrid(currentX, currentY - steps, "+");
          return new int[]{currentX, currentY - steps};
        default:
          break;
      }
      return new int[]{};
  }

  private void updateGrid(int gridX, int gridY, String wireName) {
    String current = ".";
    if (!this.grid.containsKey(gridY)) {
      this.grid.put(gridY, new HashMap<>());
    }else {
      if (this.grid.get(gridY).containsKey(gridX)) {
        current = this.grid.get(gridY).get(gridX);
      }
    }

    if (current.equals(".")) {
      this.grid.get(gridY).put(gridX, wireName);
    }else if(!current.equals(wireName) && !current.equals("o")) {
      this.grid.get(gridY).put(gridX, "X");
      this.intersectionPoints.add(new int[]{gridX, gridY});
    }
  }
}