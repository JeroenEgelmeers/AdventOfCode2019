package days.controllers.helpers;

public abstract class DayController<T> implements DayControllerInterface<T> {
  protected final String FILEPATH;
  public DayController(String filePath) {
    this.FILEPATH = filePath;
  }
}
