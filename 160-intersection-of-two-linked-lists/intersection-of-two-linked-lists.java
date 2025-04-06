/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          if (headA == null || headB == null) return null;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        HashMap<ListNode, Integer> mpp = new HashMap<>();
        while(temp1 != null){
            mpp.put(temp1, 1);
            temp1 = temp1.next;
        }
        while(temp2 != null){
            if(mpp.containsKey(temp2)){
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }
}