package days.controllers.helpers;

public interface DayControllerInterface<T, E> {
  void run();
  T solutionPartOne();
  E solutionPartTwo();
}
