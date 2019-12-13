package factorys;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFileReader {
  public List<Integer> fileToIntegerList(String filepath, String delimiter) {
    try(Scanner scanner = new Scanner(new File(filepath)).useDelimiter(delimiter)) {
      List<Integer> massList = new ArrayList<>();

      while (scanner.hasNext()) {
        massList.add(Integer.valueOf(scanner.next()));
      }

      return massList;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return null;
  }

  public List<String> fileToStringList(String filepath, String delimiter) {
    try(Scanner scanner = new Scanner(new File(filepath)).useDelimiter(delimiter)) {
      List<String> massList = new ArrayList<>();

      while (scanner.hasNext()) {
        massList.add(scanner.next());
      }

      return massList;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return null;
  }
}
