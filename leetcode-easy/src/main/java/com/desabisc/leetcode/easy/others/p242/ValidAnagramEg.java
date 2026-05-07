package com.desabisc.leetcode.easy.others.p242;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 * Topics: Hash Table, String, Sorting
 */
public class ValidAnagramEg {

    public static void main(String[] args) {
        Boolean test1 = isValidAnagramB("anagram", "nagaram");
        //Boolean test2 = isValidAnagram("car", "rat");
    }

    public static Boolean isValidAnagramA(String s, String t) {
        if (s.length() == t.length()) {
            char[] sCharArray = s.toCharArray();
            char[] tCharArray = t.toCharArray();

            Arrays.sort(sCharArray);
            Arrays.sort(tCharArray);

            String sOrdered = new String(sCharArray);
            String tOrdered = new String(tCharArray);

            return sOrdered.equals(tOrdered);
        }
        return Boolean.FALSE;
    }

    public static Boolean isValidAnagramB(String s, String t) {

        if (s.length() != t.length()) {
            return Boolean.FALSE;
        }

        // Create a hashmap to store character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count frequency of each character in string s1
        for (char currentSChar : s.toCharArray()) {
            int value = charCount.getOrDefault(currentSChar, 0) + 1;
            charCount.put(currentSChar, value);
        }

        // Count frequency of each character in string s2
        for (char currentTChar : t.toCharArray()) {
            int value = charCount.getOrDefault(currentTChar, 0) - 1;
            charCount.put(currentTChar, value);
        }

        // Check if all frequencies are zero
        for (var entry : charCount.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        // If all conditions satisfied, they are anagrams
        return true;
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static Boolean isValidAnagramC(String s, String t) {
        if (s.length() != t.length()) {
            return Boolean.FALSE;
        }

        int[] charCounts = new int[26]; // Assuming input strings contain only lowercase letters

        for (int i = 0; i < s.length(); i++) {
            // 'a' = 97 in decimal ascii
            // 'b' = 98 -->
            // 'e' = 101 -->
            // 'g' = 103 -->
            charCounts[s.charAt(i) - 'a']++; // Increment count for each character in `s`
        }

        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--; // Decrement count for each character in `t`
        }

        for (int count : charCounts) {
            if (count != 0) { // If any count is not zero, `s` and `t` are not anagrams
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

}
