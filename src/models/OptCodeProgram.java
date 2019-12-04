package models;

import java.util.List;

public class OptCodeProgram {
  private List<Integer> program;

  public OptCodeProgram(List<Integer> gravityAssistProgram) { this.program = gravityAssistProgram; }

  public List<Integer> getProgram() { return program; }

  public Integer startProgramAndReturnOutputCode() {
    restoreGravityAssistProgram();
    calculateProgram();
    return this.program.get(0);
  }

  public void calculateProgram() {
    int currentPos = 0;
    while(calculateOptCode(currentPos)) {
      currentPos += 4;
    }
  }

  private void restoreGravityAssistProgram() {
    program.set(1, 12);
    program.set(2, 2);
  }

  private boolean calculateOptCode(int currentPos) {
    Integer optCode = program.get(currentPos);
    switch(optCode) {
      case 1:
        program.set(program.get(currentPos + 3),
                      (program.get(program.get(currentPos + 1)) + program.get(program.get(currentPos + 2))));
        return true;
      case 2:
        program.set(program.get(currentPos + 3),
                      (program.get(program.get(currentPos + 1)) * program.get(program.get(currentPos + 2))));
        return true;
      case 99:
        return false;
      default:
        return false;
        // TODO: EXCEPTION, ERROR IN PROGRAM
    }
  }
}
