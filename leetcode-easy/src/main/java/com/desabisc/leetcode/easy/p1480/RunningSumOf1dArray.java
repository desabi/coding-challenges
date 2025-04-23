package com.desabisc.leetcode.easy.p1480;

import java.util.Arrays;

/**
 * Topics: Arrays, Prefix Sum
 */
public class RunningSumOf1dArray {

  /**
   * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i])
   * Return the running sum of nums.
   *
   * @param numbers the array of numbers.
   * @return an array with the running sum of nums.
   */
  public static int[] runningSum(int[] numbers) {
    // Create the array to return with the running sums
    int[] runningSum = new int[numbers.length];

    // Put the first element of numbers in the running sum
    runningSum[0] = numbers[0];

    for (int index = 1; index < numbers.length; index++) {
      runningSum[index] = runningSum[index-1] + numbers[index];
    }

    return runningSum;
  }

  public static void main(String[] args) {
    int[] numbersA = new int[] {1,2,3,4};
    int[] numbersB = new int[] {1,1,1,1,1};
    int[] numbersC = new int[] {3,1,2,10,1};

    System.out.println("" + Arrays.toString(runningSum(numbersA)));
    System.out.println("" + Arrays.toString(runningSum(numbersB)));
    System.out.println("" + Arrays.toString(runningSum(numbersC)));
  }

}
