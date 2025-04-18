package com.desabisc.leetcode.patterns.slidingwindow;

/**
 * The Sliding Window pattern is commonly used when:
 * You’re dealing with contiguous sub arrays or substrings.
 * You’re trying to find:
 * - Maximum/minimum sum of a sub array of size k
 * - Longest/shortest substring with certain properties (e.g., no repeating characters)
 * - Number of substrings with a given condition (e.g., at most k distinct characters)
 * - Sub array with a sum less than or equal to a target
 * - Anagrams or permutations of a string
 */
public class SlidingWindowEg {

  public static void main(String[] args) {
    int[] array = new int[] {2, 1, 5, 1, 3, 2};
    int k = 3;

    System.out.println(findMaxSumSubArray(array, k));
  }

  /**
   * Find the maximum sum of a sub array of size k.
   * Method to find the maximum sum of any contiguous subarray of size k.
   *
   * @param array the array
   * @param k the k value
   * @return the max value
   */
  static int findMaxSumSubArray(int[] array, int k) {
    // edge case check
    // Edge case: If array is empty or k is invalid
    if (array == null || array.length == 0 || k <= 0 || k > array.length) {
      return 0;
    }

    int windowSum = 0; // sum of the current window
    int maxSum = 0;    // To keep track of the maximum sum found

    // Step 1: Calculate sum of the first window
    for (int index = 0; index < k; index++) {
      // Get the current number in the array
      int currentNumber = array[index];
      // Add/Sum first k elements
      windowSum += currentNumber; // 0+2, 2+1, 3+5 = 8. First window
    }

    // Initialize maxSum with the sum of the first window
    maxSum = windowSum;

    // Step 2: Slide the window, one element at a time
    for (int windowEnd = k; windowEnd < array.length; windowEnd++) {
      // Subtract the element going out of the window and add the new element
      int newElement = array[windowEnd]; // move the las element of the previous windows to the right
      int removedElement = array[windowEnd - k]; // get the removed element from the current window

      // to the previous windows sum, add the new element, and subtract the removed element
      windowSum += newElement - removedElement;

      // Update maxSum if current windowSum is greater
      maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
  }
}
