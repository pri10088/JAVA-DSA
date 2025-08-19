class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: find length of list
        ListNode curr = head;
        int length = 1; 
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: connect tail to head (make it circular)
        curr.next = head;

        // Step 3: find new head after rotation
        k = k % length; // in case k > length
        int stepsToNewHead = length - k;

        // Step 4: move to the new head
        ListNode newTail = curr;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
