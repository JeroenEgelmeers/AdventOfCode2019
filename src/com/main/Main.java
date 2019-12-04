package com.main;

import factorys.DayFactory;

public class Main {
  public static void main(String[] args) {
    System.out.println("=====  Advent Of Code 2019: =====");
    new DayFactory(31, 1).run();
    System.out.println("\n===== End of Advent of Code 2019! =====");
  }
}
