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

  private void resetIntCodeList() { this.intCodeList = new ArrayList<>(this.intCodeProgramList); }

  /**
   * Calculate the program using 4 steps
   *
   * @return intCodeList after calculation is done.
   */
  public List<Integer> calculateProgram() {
    int instructionPointer = 0;
    while (runInstruction(instructionPointer)) {
      instructionPointer += 4;
    }

    return this.intCodeList;
  }

  /**
   * Run intProgram instruction from given position (must be position of an optCode).
   *
   * @param currentPos
   * @return returns true/false. If false the program should halt.
   */
  private boolean runInstruction(int currentPos) {
    Integer optCode = intCodeList.get(currentPos);
    Integer intOutput;

    intOutput = intCodeList.size() > currentPos+2 ?
      runOptCode(optCode, intCodeList.get(currentPos + 1), intCodeList.get(currentPos + 2)) :
      runOptCode(optCode, null, null);

    if (intOutput != null) {
      intCodeList.set(intCodeList.get(currentPos + 3), (Integer)intOutput);
      return true;
    }

    return false;
  }

  /**
   * find noun and verb for given output.
   *
   * @param output
   * @return the noun and verb in an int[]
   */
  public int[] findOutput(int output) {
    for (int noun = 0; noun < 100; noun++) {
      for (int verb = 0; verb < 100; verb++) {
        restoreGravityAssistProgram(noun, verb);
        if (calculateProgram().get(0) == output) { return new int[] {noun, verb}; }
      }
    }

    return new int[]{};
  }


  public void restoreGravityAssistProgram(int nuon, int verb) {
    resetIntCodeList();
    intCodeList.set(1, nuon);
    intCodeList.set(2, verb);
  }

  /**
   * An optCode should call certain method (plus, multiply, halt etc.).
   *
   * @param optCode
   * @param leftHandValue
   * @param rightHandValue
   *
   * @return the outcome for a given optcode with it's left/rigth hand value.
   */
  private Integer runOptCode(int optCode, Integer leftHandValue, Integer rightHandValue) {
    switch(optCode) {
      case 1: return plus(leftHandValue, rightHandValue);
      case 2: return multiply(leftHandValue, rightHandValue);
      case 99:
      default: return halt();
    }
  }

  private int plus(Integer leftInputValue, Integer rightInputValue) {
    return intCodeList.get(leftInputValue) + intCodeList.get(rightInputValue);
  }

  private int multiply(Integer leftInputValue, Integer rightInputValue) {
    return intCodeList.get(leftInputValue) * intCodeList.get(rightInputValue);
  }

  private Integer halt() { return null; }
}
