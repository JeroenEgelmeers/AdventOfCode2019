package factorys;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.MessageFormat;

public class DayFactory {
  private static final String   PACKAGE     = "days.controllers";
  private static final String   CONTROLLER  = "Day{0}Controller";
  private static final String   METHOD_NAME = "run";
  private static final String   PATH_TO_FILE = "C:/Workspace/AdventOfCode2019/src/days/textFiles/day{0}.txt";

  private int amountDays;
  private int startDay;

  public DayFactory(int days, int startDay) {
    this.amountDays = days;
    this.startDay   = startDay;
  }

  public void run() {
      for(int day = startDay; day < amountDays + 1; day++) {
        System.out.println("\n~ Day "+day+" ~");
        getClassForDay(day);
      }
  }

  private void getClassForDay(int day) {
    try {
      Class curClass = Class.forName(PACKAGE + "." + MessageFormat.format(CONTROLLER, day));
      Constructor<String> cons = curClass.getConstructor(String.class);
      Method method = curClass.getMethod(METHOD_NAME);
      Object newInstance = cons.newInstance(MessageFormat.format(PATH_TO_FILE, day));
      method.invoke(newInstance);
    }catch(ClassNotFoundException e) {
      System.out.println("Not yet implemented.");
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}
