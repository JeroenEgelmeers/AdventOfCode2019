package days.controllers.helpers;

public interface DayControllerInterface<T> {
  void run();
  T solutionPartOne();
  T solutionPartTwo();
}
