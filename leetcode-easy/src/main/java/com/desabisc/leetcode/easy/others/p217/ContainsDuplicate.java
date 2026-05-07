package com.desabisc.leetcode.easy.others.p217;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/description/
 * Topics: Array, Hash Table, Sorting
 */
public class ContainsDuplicate {
  public static void main(String[] args) {
    int[] numbers = new int[] {1,2,3,1};
    System.out.println(solution1(numbers));;
  }

  static boolean solution1(int[] numbers) {
    HashSet<Integer> duplicates = new HashSet<>();

    for (int currentNumber : numbers) {
      if (duplicates.contains(currentNumber)) {
        return true;
      }

      duplicates.add(currentNumber);
    }
    return false;
  }
}
