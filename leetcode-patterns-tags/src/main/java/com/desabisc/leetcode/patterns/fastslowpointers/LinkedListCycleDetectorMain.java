package com.desabisc.leetcode.patterns.fastslowpointers;

public class LinkedListCycleDetectorMain {

  public static void main(String[] args) {

    LinkedListCycleDetector linkedListCycleDetector = new LinkedListCycleDetector();

    // Create a linked list WITHOUT a cycle: 1 -> 2 -> 3 -> 4 -> 5
    ListNode noCycleHead = new ListNode(1);
    noCycleHead.next = new ListNode(2);
    noCycleHead.next.next = new ListNode(3);
    noCycleHead.next.next.next = new ListNode(4);
    noCycleHead.next.next.next.next = new ListNode(5);

    // Create a linked list WITH a cycle: 1 -> 2 -> 3 -> 4 -> 5 -> back to 3
    ListNode cycleHead = new ListNode(1);
    cycleHead.next = new ListNode(2);
    cycleHead.next.next = new ListNode(3);
    cycleHead.next.next.next = new ListNode(4);
    cycleHead.next.next.next.next = new ListNode(5);

    // cycleHead.next.next.next.next.next → normally this would be null, but we're making it point to node 3.
    // The cycle start is determined by which node you point the last node to.

    // You (the programmer) define where the cycle starts by deciding which node’s next points back
    // to an earlier node in the list.
    // You want to turn it into a cycle, so you set cycleHead.next.next.next.next.next to point
    // somewhere earlier in the list.
    // By choosing cycleHead.next.next, you define the entry point of the cycle.
    cycleHead.next.next.next.next.next = cycleHead.next.next; // Point back to node 3

    // Test the list without cycle
    System.out.println("Testing list without cycle:");
    System.out.println("Expected: false");
    System.out.println("Actual: " + linkedListCycleDetector.hasCycle(noCycleHead));
    System.out.println();

    // Test the list with cycle
    System.out.println("Testing list with cycle:");
    System.out.println("Expected: true");
    System.out.println("Actual: " + linkedListCycleDetector.hasCycle(cycleHead));

    // Visualization of the cyclic list:
    // 1 → 2 → 3 → 4 → 5
    //         ↑______|
  }

}
