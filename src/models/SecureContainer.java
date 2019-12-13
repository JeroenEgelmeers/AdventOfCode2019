package models;

public class SecureContainer {

  public boolean passwordIsValid(int password, int[] range) {
    return isSixDigits(password) &&
            isInRange(password, range) &&
            hasTwoEqualAdjacentDigits(password) &&
            isDigitsNeverDecrease(password);
  }

  private boolean isSixDigits(int password) { return password < 999999; }
  private boolean isInRange(int password, int[] range) { return password > range[0] && password < range[1]; }
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
