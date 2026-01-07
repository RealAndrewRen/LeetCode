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
        if (head.next == null){
            return false;
        }
        Set<ListNode> visited = new HashSet<>();
        while (head.next != null){
            visited.add(head);
            head = head.next;
            if (visited.contains(head)){
                return true;
            }
        }
        return false;
    }
}