package com.desabisc.leetcode.patterns.fastslowpointers;

/**
 * The Fast and Slow Pointers pattern is super helpful for solving many linked list and array problems.
 * The Fast and Slow Pointers (a.k.a. Floyd’s Tortoise and Hare) is a two-pointer technique where:
 *  - The slow pointer moves one step at a time.
 *  - The fast pointer moves two steps at a time.
 * This allows the fast pointer to "lap" the slow one, revealing patterns like loops or
 * finding the middle of a structure efficiently.
 */
public class LinkedListCycleDetector {
  /**
   * Function to detect cycle in a linked list using Fast and Slow pointers.
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    // Edge case: empty list or single node with no cycle
    if (head == null || head.next == null) {
      return false;
    }

    // Initialize two pointers - slow moves 1 step, fast moves 2 steps
    ListNode slow = head;
    ListNode fast = head.next;

    // Loop until either fast reaches end or pointers meet
    while (slow != fast) {
      // If fast reaches the end (or beyond), no cycle exists
      if (fast == null || fast.next == null) {
        return false;
      }

      // Move slow by 1 step
      slow = slow.next;
      // Move fast by 2 steps
      fast = fast.next.next;
    }

    // If we exit the loop, slow == fast, meaning cycle exists
    return true;
  }
}
