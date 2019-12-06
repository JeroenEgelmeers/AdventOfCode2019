package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WiresPathCalculator {
  private String wireOne;
  private String wireTwo;
  private int centralPointX;
  private int centralPointY;

  private String[][] grid;
  private List<int[]> intersectionPoints;

  public WiresPathCalculator(int gridX, int gridY, List<String> wires) {
    this.intersectionPoints = new ArrayList<>();
    this.wireOne = wires.get(0).replaceAll("(\\r|\\n)", "");
    this.wireTwo = wires.get(1).replaceAll("(\\r|\\n)", "");
    this.grid = new String[gridX][gridY];
    initGrid(gridX, gridY);
    renderWireInGrid(Arrays.asList(this.wireOne.split(",")));
    renderWireInGrid(Arrays.asList(this.wireTwo.split(",")));
  }

  private void renderWireInGrid(List<String> wire) {
    int[] currentPos = { centralPointX, centralPointY };
    for(String position : wire) {
      currentPos = wireAction(position, currentPos[0], currentPos[1]);
    }
  }

  // TODO: Better name; get closest point from central point where wires hit eachother.
  public int[] getClosestMatch() {
    int[] closest = {};
    for(int[] iPoint : this.intersectionPoints) {
       if (closest.length == 0) { closest = iPoint; }
       if (Math.abs(centralPointX+centralPointY - iPoint[0]+iPoint[1]) < Math.abs(centralPointX+centralPointY - closest[0]+closest[1])) {
         closest = iPoint;
       }
    }

    return closest;
  }

  public int getDistanceToCentralPoint(int[] iPoint) {
    return (iPoint[0] - this.centralPointX) + (iPoint[1] - this.centralPointY);
  }

  private int[] wireAction(String action, int currentX, int currentY) {
    int steps = 0;
    try {
       steps = Integer.parseInt(action.substring(1));
      }catch(NumberFormatException e) {
        System.out.println(e);
      }

      switch(action.charAt(0)) {
        case 'R':
          for(int i = currentX + 1; i < currentX+steps-1; i++) { updateGrid(i, currentY); }
          this.grid[currentX+steps][currentY] = "+";
          return new int[]{currentX + steps, currentY};
        case 'U':
          for(int i = currentY+steps - 1; i > currentY-1; i--) { updateGrid(currentX, i); }
          this.grid[currentX][currentY - steps] = "+";
          return new int[]{currentX, currentY - steps};
        case 'L':
          for(int i = currentX+steps-1; i > currentX-1; i--) { updateGrid(i, currentY); }
          this.grid[currentX - steps][currentY] = "+";
          return new int[]{currentX - steps, currentY};
        case 'D':
          for(int i = currentY+1; i < currentY+steps-1; i++) { updateGrid(currentX, i); }
          this.grid[currentX][currentY + steps] = "+";
          return new int[]{currentX, currentY + steps};
        default:
          break;
      }
      return new int[]{};
  }

  private void updateGrid(int gridX, int gridY) {
    if (this.grid[gridX][gridY].equals(".")) {
      this.grid[gridX][gridY] = "-";
    }else {
      this.grid[gridX][gridY] = "X";
      this.intersectionPoints.add(new int[]{gridX, gridY});
    }
  }

  private void initGrid(int gridX, int gridY) {
    for (int row = 0; row < gridX; row++)
    {
      for (int column = 0; column < gridY; column++) {
        if (row == (int)(gridX*(70/100.0f)) && column == (int)(gridY*(20/100.0f))) {
          grid[row][column] = "o";
          this.centralPointX = row;
          this.centralPointY = column;
        }else {
          grid[row][column] = ".";
        }

      }
    }
  }

  public void printGrid() {
    for (String[] row : grid)
    {
      for (String value : row)
      {
        System.out.printf("%2s ", value);
      }
      System.out.println("");
    }
  }


}