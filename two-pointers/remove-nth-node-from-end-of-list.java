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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null && n == 1){
            return null;
        }
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        int index = size - n;
        curr = head;
        ListNode prev = null;
        for (int i = 0; i < index; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = (curr.next == null) ? null : curr.next;
        return head;
    }
}