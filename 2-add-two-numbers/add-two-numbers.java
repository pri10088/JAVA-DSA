/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to hold the result
        ListNode current = dummy;  // Pointer to track the new list
        int carry = 0;  // Variable to handle carry

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with carry

            if (l1 != null) {
                sum += l1.val;  // Add l1's value
                l1 = l1.next;    // Move to next node
            }

            if (l2 != null) {
                sum += l2.val;  // Add l2's value
                l2 = l2.next;    // Move to next node
            }

            carry = sum / 10;  // Calculate new carry
            current.next = new ListNode(sum % 10); // Store last digit
            current = current.next; // Move pointer
        }

        return dummy.next; // Return the resulting list
    }
}
