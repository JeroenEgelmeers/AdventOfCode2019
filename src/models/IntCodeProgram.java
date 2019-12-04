package models;

import java.util.ArrayList;
import java.util.List;

public class IntCodeProgram {
  private final List<Integer> intCodeProgramList;
  private       List<Integer> intCodeList;

  public IntCodeProgram(final List<Integer> gravityAssistProgram) {
    this.intCodeProgramList = new ArrayList<>(gravityAssistProgram);
    resetIntCodeList();
  }

  public List<Integer>  getIntCodeList() { return intCodeList; }
  private void          resetIntCodeList() { this.intCodeList = new ArrayList<>(this.intCodeProgramList); }

  public Integer startProgramAndReturnOutputCode() {
    restoreGravityAssistProgram(12, 2);
    calculateProgram();
    return this.intCodeList.get(0);
  }

  public void calculateProgram() {
    int instructionPointer = 0;
    while (runInstruction(instructionPointer)) {
      instructionPointer += 4;
    }
  }

  private void restoreGravityAssistProgram(int nuon, int verb) {
    resetIntCodeList();
    intCodeList.set(1, nuon);
    intCodeList.set(2, verb);
  }

  public int[] findOutput(int output) {
    for (int noun = 0; noun < 100; noun++) {
      for (int verb = 0; verb < 100; verb++) {
        restoreGravityAssistProgram(noun, verb);
        calculateProgram();

        if (this.intCodeList.get(0) == output) { return new int[] {noun, verb}; }
      }
    }

    return new int[]{};
  }

  private boolean runInstruction(int currentPos) {
    Integer optCode = intCodeList.get(currentPos);
    switch (optCode) {
      case 1:
        intCodeList.set(intCodeList.get(currentPos + 3),
                          plus(intCodeList.get(currentPos + 1), intCodeList.get(currentPos + 2)));
        return true;
      case 2:
        intCodeList.set(intCodeList.get(currentPos + 3),
                          multiply(intCodeList.get(currentPos + 1), intCodeList.get(currentPos + 2)));
        return true;
      case 99:
      default:
        return false;
    }
  }

  private int plus(int leftInputValue, int rightInputValue) {
    return intCodeList.get(leftInputValue) + intCodeList.get(rightInputValue);
  }

  private int multiply(int leftInputValue, int rightInputValue) {
    return intCodeList.get(leftInputValue) * intCodeList.get(rightInputValue);
  }
}
