/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> mpp = new HashMap<>();
        ListNode temp = head;
        if(head == null || head.next == null){
            return false;
        }
        while(temp != null){
            if(mpp.containsKey(temp)){
                return true;
            }
            mpp.put(temp,1);
            temp = temp.next;
        }
        return false;
        
        
    }
}