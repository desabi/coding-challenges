package com.desabisc.leetcode.patterns.prefixsum;

import java.util.Arrays;

/**
 * <p>Demonstrates the Prefix Sum pattern for efficient range sum queries. This class preprocesses an
 * array to answer multiple range sum queries in O(1) time.</p>
 * <p> Time Complexity: O(n) for preprocessing, O(1) for each query Space Complexity: O(n) for storing
 * the prefix sum array.</p>
 *<p><a href="https://claude.ai/chat/7daaa587-4cec-4603-95d5-23ea4493ec50">Claude Source</a></p>
 */
public class PrefixSumRangeQuery {

  // Array to store cumulative sums
  public int[] prefixSum;

  /**
   * Constructor that initializes the prefix sum array.
   *
   * @param numbers The input array for which we want to perform range queries
   */
  public PrefixSumRangeQuery(int[] numbers) {
    // Initialize prefix sum array with same length as input
    prefixSum = new int[numbers.length];

    // Base case: first element remains the same
    if (numbers.length > 0) {
      prefixSum[0] = numbers[0];
    }

    // Build the prefix sum array by adding current element to previous sum
    // prefixSum[index] represents the sum of all elements from index 0 to index
    for (int index = 1; index < numbers.length; index++) {
      prefixSum[index] = prefixSum[index - 1] + numbers[index];
    }
  }

  /**
   * Calculates the sum of elements between left and right indices (inclusive).
   *
   * @param left  The starting index of the range (inclusive)
   * @param right The ending index of the range (inclusive)
   * @return The sum of elements in the specified range
   * <p>
   * Formula explanation: - If left is 0, return prefixSum[right] (sum from start to right) -
   * Otherwise, return prefixSum[right] - prefixSum[left - 1] This works because prefixSum[right]
   * contains sum[0...right] and prefixSum[left-1] contains sum[0...left-1] Their difference gives
   * us sum[left...right]
   */
  public int rangeSum(int left, int right) {
    // Handle edge case when range starts from index 0
    if (left == 0) {
      return prefixSum[right];
    }

    // Subtract the prefix sum before 'left' to get the range sum
    return prefixSum[right] - prefixSum[left - 1];
  }

  /**
   * Main method demonstrating usage with examples.
   */
  public static void main(String[] args) {
    int[] numbers = {3, 1, 4, 2, 5, 9};

    // Create prefix sum object (preprocessing step)
    PrefixSumRangeQuery prefixSumRangeQuery = new PrefixSumRangeQuery(numbers);

    // print numbers and prefixSum arrays
      System.out.println("numbers: " + Arrays.toString(numbers));
      System.out.println("prefixSum: " + Arrays.toString(prefixSumRangeQuery.prefixSum));

    // Query 1: Sum from index 2 to 4
    // Expected: numbers[2] + numbers[3] + numbers[4] = 4 + 2 + 5 = 11
    System.out.println("Sum from index 2 to 4: " + prefixSumRangeQuery.rangeSum(2, 4)); // Output: 11

    // Query 2: Sum from index 0 to 5 (entire array)
    // Expected: 3 + 1 + 4 + 2 + 5 + 9 = 24
    System.out.println("Sum from index 0 to 5: " + prefixSumRangeQuery.rangeSum(0, 5)); // Output: 24

    // Query 3: Sum from index 1 to 3
    // Expected: numbers[1] + numbers[2] + numbers[3] = 1 + 4 + 2 = 7
    System.out.println("Sum from index 1 to 3: " + prefixSumRangeQuery.rangeSum(1, 3)); // Output: 7
  }
}