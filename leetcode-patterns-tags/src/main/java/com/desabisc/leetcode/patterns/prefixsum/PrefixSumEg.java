package com.desabisc.leetcode.patterns.prefixsum;

public class PrefixSumEg {

    public static void main(String[] args) {
        int[] numbers = {2, 4, 1, 5, 3};

        exampleA(numbers);
    }

    /**
     * You want to quickly find the sum between any two indices, say from index 1 to 3.
     * @param numbers
     */
    static void exampleA(int[] numbers) {
        // Create prefix sum array
        int[] prefixSum = new int[numbers.length];

        // put the firs element of numbers in the prefix array
        prefixSum[0] = numbers[0];

        // populate the prefixSum array with the sum of the values of the numbers array
        for (int index = 1; index < numbers.length; index++) {
            int prefixSumPreviousNumber = prefixSum[index - 1];
            int numbersCurrentNumber = numbers[index];
            prefixSum[index] = prefixSumPreviousNumber + numbersCurrentNumber;
        }

        // Print the prefix sum array
        System.out.print("Prefix Sum Array: ");
        for (int number : prefixSum) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Example: Get sum between index 1 and 3 (inclusive)
        // Subtraction removes the part we do not want: left - 1
        int left = 1;
        int right = 3;
        int sum = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
        System.out.println("Sum from index " + left + " to " + right + ": " + sum);

        // Another example: Get sum of entire array
        int totalSum = prefixSum[prefixSum.length - 1];
        System.out.println("Total sum of array: " + totalSum);
    }
}