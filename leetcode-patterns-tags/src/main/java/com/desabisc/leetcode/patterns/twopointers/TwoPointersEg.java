package com.desabisc.leetcode.patterns.twopointers;

import java.util.Arrays;

/**
 * The Two Pointers pattern is a powerful and commonly used technique in problems that involve:
 * - Searching pairs or sub arrays in sorted arrays or strings.
 * - In-place operations without using extra memory.
 * - Solving O(n²) problems in O(n) or O(n log n).
 */
public class TwoPointersEg {

  public static void main(String[] args) {
    int[] array = {1, 2, 4, 4, 7, 11, 15};
    int target = 9;
    //System.out.println("Result: " + hasPairWithSum(array, target));

    char[] s1 = new char[] {'a', 'b', 'c', 'd', 'e'};
    char[] s2 = new char[] {'h', 'e', 'l', 'l', 'o'};
    char[] s3 = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
    //System.out.println("Result: " + Arrays.toString(reverse(s3)));

    String s = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s));
  }

  /**
   * Let’s say we have an array, and we want to find if there is a pair of numbers that adds up to a
   * given target (e.g., target = 9).
   *
   * @param array the array
   * @param target the target
   * @return boolean value
   */
  static boolean hasPairWithSum(int[] array, int target) {
    // Step 1: Sort the array (two-pointer technique works on sorted arrays)
    Arrays.sort(array);

    // Step 2: Initialize two pointers
    int leftPointer = 0;
    int rightPointer = array.length - 1;

    // Step 3: Traverse the array using the two pointers
    while (leftPointer < rightPointer) {
      int sum = array[leftPointer] + array[rightPointer]; // Calculate the sum of values at both pointers

      if (sum == target) {
        return true; // Found the pair that sums to the target
      } else if (sum < target) {
        leftPointer++; // Need a larger sum, move the left pointer to the right
      } else {
        rightPointer--; // Need a smaller sum, move the right pointer to the left
      }
    }

    // No pair found
    return false;
  }

  static char[] reverse(char[] chars) {
    // Initialize two pointers:
    int leftPointer = 0; // start of the array
    int rightPointer = chars.length - 1; // end of the array

    while (leftPointer < rightPointer) {
      char temp = chars[leftPointer];           // store left character in temp
      chars[leftPointer] = chars[rightPointer]; // copy right character to left
      chars[rightPointer] = temp;               // copy temp (original left) to right

      // Move the pointers
      leftPointer++;  // move forward from the beginning
      rightPointer--; // move backward from the end
    }
    return chars;
  }

  /**
   * Given a string s, determine if it is a palindrome, considering only alphanumeric characters
   * and ignoring cases.
   *
   * @param s the string
   * @return a boolean value
   */
  static boolean isPalindrome(String s) {
    // initialize two pointers
    int leftPointer = 0;
    int rightPointer = s.length() - 1;

    while (leftPointer < rightPointer) {
      // move left pointer to the right if it is not alphanumeric
      while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))) {
        leftPointer++;
      }

      // move right pointer to the left it it is not alphanumeric
      while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(rightPointer))) {
        rightPointer--;
      }

      // compare characters (case sensitive)
      if (Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))) {
        return false;
      }

      // move both pointers inward
      leftPointer++;
      rightPointer--;
    }

    return true;
  }
}
