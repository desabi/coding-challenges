package com.desabisc.leetcode.easy.others.p1929;

/**
 * https://leetcode.com/problems/concatenation-of-array/description/
 * Topics: Mid-Level, Array, Simulation, Weekly Contest 249
 */
public class ConcatenationOfArrayEg {

    private static int[] concatenationOfArray(int[] nums) {
        // create the ans array with 2n size, where n is the nums length.s
        int[] ans = new int [2 * nums.length];

        // add the values from the num array to the ans array.
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }

        // add again the content of nums to the ans array.
        // start in the end of the ans array.
        // to get the last position, use the length fo the nums array.
        int numsLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            ans[numsLength] = nums[i];
            numsLength++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ints = concatenationOfArray(new int[]{1, 2, 1});
    }
}
