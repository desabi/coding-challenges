package com.desabisc.leetcode.easy.twopointers.p23;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesSortedArray {

  public static void main(String[] args) {
    int[] numbers = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int k = removeDuplicates(numbers);
    System.out.println("" + Arrays.toString(numbers));
    System.out.println("k = " + k);
  }

  static int removeDuplicates(int[] numbers) {
    // Handle edge case: if array is empty, return 0
    if (numbers.length == 0) {
      return 0;
    }

    // Initial state
    // slow pointer starts at 0 index
    int slowPointer = 0;

    // fast pointer starts at 1 index
    for (int fastPointer = 1; fastPointer < numbers.length ; fastPointer++) {
      if (numbers[slowPointer] != numbers[fastPointer]) {
        // Move slow pointer forward
        slowPointer++;
        // copy the new different value to the previous repeated value
        numbers[slowPointer] = numbers[fastPointer];
      }
      // if elements are equals, just move forward faster pointer
    }

    // Return the length of the new array (position of slow pointer + 1)
    return slowPointer + 1;
  }
}
