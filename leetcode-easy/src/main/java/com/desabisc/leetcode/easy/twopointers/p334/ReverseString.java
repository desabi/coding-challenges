package com.desabisc.leetcode.easy.twopointers.p334;

/**
 * https://leetcode.com/problems/reverse-string/description/
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
  public static void main(String[] args) {
    char[] s1 = new char[] {'a', 'b', 'c', 'd', 'e'};
    char[] s2 = new char[] {'h', 'e', 'l', 'l', 'o'};
    char[] s3 = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};

    reverseString(s1);
    reverseString(s2);
    reverseString(s3);
  }

  public static void reverseString(char[] chars) {
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
    System.out.println(chars);
  }
}
