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
    int[] nums1 = new int[] {11, 2, 15, 7, 1};
    int target1 = 9;

    int[] nums2 = new int[] {3,2,4};
    int target2 = 6;

    int[] nums3 = new int[] {3, 3};
    int target3 = 6;

    System.out.println(Arrays.toString(twoSumSolution2(nums1, target1)));
    System.out.println(Arrays.toString(twoSumSolution2(nums2, target2)));
    System.out.println(Arrays.toString(twoSumSolution2(nums3, target3)));
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

    // 11, 2, 15, 7
    for (int index = 0; index < nums.length; index++) {
      int currentNumber = nums[index];
      int complement = target - currentNumber;

      // Check if the complement exists in the map
      if (map.containsKey(complement)) {
        // map -> key, value
        // map -> current number, index
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
