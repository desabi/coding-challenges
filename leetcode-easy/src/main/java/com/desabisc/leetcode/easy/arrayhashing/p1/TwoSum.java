package com.desabisc.leetcode.easy.arrayhashing.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Arrays & Hashing.
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
  public static void main(String[] args) {
    int[] nums = new int[] {11, 2, 15, 7};
    int target = 9;

    twoSumSolution2(nums, target);
  }

  static int[] twoSumSolution1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return nums;
  }

  static int[] twoSumSolution2(int[] nums, int target) {
    // Create a hash map to store the value and its index
    Map<Integer, Integer> map = new HashMap<>(); // number complement -> index

    for (int index = 0; index < nums.length; index++) {
      int currentNumber = nums[index];
      int complement = target - currentNumber;

      // Check if the complement exists in the map
      if (map.containsKey(complement)) {
        // map -> key, value
        // map -> number complement, index
        Integer complementIndex = map.get(complement);
        return new int[] {complementIndex, index };
      }

      // Put the current number and its index into the map
      map.put(currentNumber, index);
    }

    // In case there is no solution (but per problem statement, there always is)
    return new int[] {};
  }
}
