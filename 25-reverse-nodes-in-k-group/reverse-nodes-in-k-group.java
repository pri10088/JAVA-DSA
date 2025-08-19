class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node before head (for easy handling of edge cases)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev points to the node before the current group
        ListNode prev = dummy;
        ListNode curr = head;

        // Count total nodes
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Loop until we run out of complete groups
        while (count >= k) {
            curr = prev.next;   // first node of the group
            ListNode next = curr.next; // node after curr

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;  // detach next
                next.next = prev.next;  // move it to the front
                prev.next = next;       // link prev to next
                next = curr.next;       // move next forward
            }

            // Move prev forward for next group
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}
