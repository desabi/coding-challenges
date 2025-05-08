package com.desabisc.leetcode.easy.twopointers.p125;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
  public static void main(String[] args) {
    String s1 = "A man, a plan, a canal: Panama";
    String s2 = "race a car";
    String s3 = "";

    System.out.println(isPalindrome(s1));
    System.out.println(isPalindrome(s2));
    System.out.println(isPalindrome(s3));
  }

  static boolean isPalindrome(String s) {
    // initialize two pointers
    int leftPointer = 0;
    int rightPointer = s.length() - 1;

    while (leftPointer < rightPointer) {
      // move left pointer to the right if it is not alphanumeric
      while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))) {
        leftPointer++;
      }

      // move right pointer to the left it is not alphanumeric
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
