package com.desabisc.leetcode.easy.p724;

/**
 * Topics: Array, Prefix Sum. <br>
 * <a href="https://leetcode.com/problems/find-pivot-index/description/">724. Find Pivot Index</a>
 */
public class FindPivotIndexEg {

  public static int pivotIndex(int[] numbers) {
    // Calculate the total sum of the array
    int totalSum = 0;
    for (int currentNumber: numbers) {
      totalSum = totalSum + currentNumber;
    }

    int leftSum = 0; // Initialize left cumulative sum

    // numbers = {1,7,3,6,5,6}
    for (int index = 0; index < numbers.length; index++) {
      // Compute right sum: totalSum - leftSum - current element
      // index = 0, totalSum = 28, leftSum = 0, numbers[0] = 1 --> rightSum = 28 - 0 - 1 = 27
      // index = 1; totalSum = 28, leftSum = 1, numbers[1] = 7 --> rightSum = 28 - 1 - 7 = 20
      // index = 2, totalSum = 28, leftSum = 8, numbers[2] = 3 --> rightSum = 28 - 8 - 3 = 17
      // index = 3, totalSum = 28, leftSum = 11, numbers[3] = 6 --> rightSum = 28 - 11 - 6 = 11
      int rightSum = totalSum - leftSum - numbers[index];

      // Check if leftSum is equals to rightSum
      // index = 0, leftSum = 0, rightSum = 27 --> 0 == 27, false
      // index = 1, leftSum = 1, rightSum = 20 --> 1 == 20, false
      // index = 2, leftSum = 8, rightSum = 17 --> 8 == 17, false
      // index = 3, leftSum = 11, rightSum = 11 --> 11 == 11, true
      if (leftSum == rightSum) {
        return index;
      }

      // Update leftSum for the next iteration
      // index = 0, leftSum = 0, numbers[0] = 1. leftSum = 0 + 1 --> 1
      // index = 1, leftSum = 1, numbers[1] = 7. leftSum = 1 + 7 --> 8
      // index = 2, leftSum = 8, numbers[2] = 3. leftSum = 8 + 3 --> 11
      leftSum = leftSum + numbers[index];
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] numbersA = new int[]{1,7,3,6,5,6};
    int[] numbersB = new int[]{1,2,3};
    int[] numbersC = new int[]{2,1,-1};

    System.out.println("index at: " + pivotIndex(numbersA));
    System.out.println("index at: " + pivotIndex(numbersB));
    System.out.println("index at: " + pivotIndex(numbersC));
  }
}
