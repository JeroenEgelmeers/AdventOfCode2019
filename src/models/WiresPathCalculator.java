package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WiresPathCalculator {
  private int centralPointX = 0;
  private int centralPointY = 0;

  private HashMap<Integer, HashMap<Integer, String>> grid = new HashMap();
  private List<int[]> intersectionPoints;

  public WiresPathCalculator(List<String> wires) {
    this.intersectionPoints = new ArrayList<>();
    String currentChar = "A";
    for(String wire : wires) {
      String stripWire = wire.replaceAll("(\\r|\\n)", "");
      renderWireInGrid(Arrays.asList(stripWire.split(",")), currentChar);
      currentChar = String.valueOf((char)(currentChar.charAt(0)+1));
    }
  }

  private void renderWireInGrid(List<String> wire, String wireName) {
    int[] currentPos = { centralPointX, centralPointY };
    int curStep = 1;
    for(String position : wire) {
      currentPos = wireAction(position, wireName, currentPos, curStep);
      curStep += Integer.valueOf(position.replaceAll("[^\\d]", ""));
    }
  }

  public int getClosestIntersectionPoint() {
    int closest = Integer.MAX_VALUE;
    for(int[] iPoint : this.intersectionPoints) {
       int distance = getDistanceToCentralPoint(iPoint);
       if (distance < closest ) {
         closest = distance;
       }
    }

    return closest;
  }

  public int getFewestStepsToIntersectionPoint() {
    int lowest = -1;
    for(int[] iPoint : this.intersectionPoints) {
      if (iPoint.length > 2 && (iPoint[2] < lowest || lowest == -1)) {
        lowest = iPoint[2];
      }
    }

    return lowest;
  }

  private int getDistanceToCentralPoint(int[] iPoint) {
    return Math.abs(iPoint[0] - this.centralPointX) + Math.abs(iPoint[1] - this.centralPointY);
  }

  private int[] wireAction(String action, String wireName, int[] currentPos, int curStep) {
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
          for(int i = currentX + 1; i < currentX + (steps - 1); i++) {
            updateGrid(i, currentY, wireName, curStep);
            curStep++;
          }
          updateGrid(currentX + steps, currentY, "+", curStep);
          return new int[]{currentX + steps, currentY};
        case 'U':
          for(int i = currentY + 1; i < currentY + (steps - 1); i++) {
            updateGrid(currentX, i, wireName, curStep);
            curStep++;
          }
          updateGrid(currentX, currentY + steps, "+", curStep);
          return new int[]{currentX, currentY + steps};
        case 'L':
          for(int i = currentX - 1; i > currentX - (steps - 1); i--) {
            updateGrid(i, currentY, wireName, curStep);
            curStep++;
          }
          updateGrid(currentX - steps, currentY, "+", curStep);
          return new int[]{currentX - steps, currentY};
        case 'D':
          for(int i = currentY - 1; i > currentY  - (steps - 1); i--) {
            updateGrid(currentX, i, wireName, curStep);
            curStep++;
          }
          updateGrid(currentX, currentY - steps, "+", curStep);
          return new int[]{currentX, currentY - steps};
        default:
          break;
      }
      return new int[]{};
  }

  private void updateGrid(int gridX, int gridY, String wireName, int curStep) {
    String current = ".";
    if (!this.grid.containsKey(gridY)) {
      this.grid.put(gridY, new HashMap<>());
    }else {
      if (this.grid.get(gridY).containsKey(gridX)) {
        current = this.grid.get(gridY).get(gridX);
      }
    }

    if (current.equals(".")) {
      this.grid.get(gridY).put(gridX, wireName + curStep);
    }else if(!current.replaceAll("\\d","").equals(wireName) && !current.equals("o")) {
      int stepsPreviousWire = Integer.parseInt(current.replaceAll("[^\\d]", ""));
      this.grid.get(gridY).put(gridX, "X");
      this.intersectionPoints.add(new int[]{gridX, gridY, stepsPreviousWire + curStep});
    }
  }
}