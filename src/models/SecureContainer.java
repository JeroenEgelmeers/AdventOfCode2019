package models;

public class SecureContainer {

  public boolean passwordIsValid(int password, int[] range, boolean groupedAdjacentDigits) {
    if (groupedAdjacentDigits) {
      return isSixDigits(password) &&
        isInRange(password, range) &&
        hasTwoEqualAdjacentDigitsAndNotGrouped(password) &&
        isDigitsNeverDecrease(password);
    }else {
      return isSixDigits(password) &&
        isInRange(password, range) &&
        hasTwoEqualAdjacentDigits(password) &&
        isDigitsNeverDecrease(password);
    }
  }

  private boolean isSixDigits(int password) { return password >= 100000 && password <= 999999; }
  private boolean isInRange(int password, int[] range) { return password >= range[0] && password <= range[1]; }

  private boolean hasTwoEqualAdjacentDigits(int password) {
    String numberString = Integer.toString(password);
    char previous = 0;
    for (int i = 0; i < numberString.length(); i++){
      char c = numberString.charAt(i);
      if (c == previous) { return true; }
      previous = c;
    }
    return false;
  }

  private boolean hasTwoEqualAdjacentDigitsAndNotGrouped(int password) {
    String numberString = Integer.toString(password);
    char    previous          = 0;
    int     sameCharInRow     = 1;
    boolean foundMatch = false;

    for (int i = 0; i < numberString.length(); i++){
      char c = numberString.charAt(i);
      if (c == previous) {
        sameCharInRow++;
      }else {
        if (sameCharInRow > 1) {
          if (sameCharInRow == 2) { return true; }
          sameCharInRow = 1;
        }
      }
      previous = c;
    }

    return sameCharInRow == 2;
  }

  private boolean isDigitsNeverDecrease(int password) {
    String numberString = Integer.toString(password);
    char previous = 0;
    for (int i = 0; i < numberString.length(); i++){
      char c = numberString.charAt(i);
      if (c < previous) { return false; }
      previous = c;
    }

    return true;
  }
}
