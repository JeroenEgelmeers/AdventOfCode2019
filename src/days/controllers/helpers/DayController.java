package days.controllers.helpers;

public abstract class DayController<T, E> implements DayControllerInterface<T, E> {
  protected final String FILEPATH;
  public DayController(String filePath) {
    this.FILEPATH = filePath;
  }
}
