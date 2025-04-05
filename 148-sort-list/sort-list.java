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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return mergeSort(left, right);

        
    }
    private ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
      
        while(fast != null && fast.next != null && fast.next.next != null){
           
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode mergeSort(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
            
        }
        if(l1 != null){
            temp.next = l1;
        }else if( l2 != null){
            temp.next = l2;
        }
        return dummy.next;
    }
}