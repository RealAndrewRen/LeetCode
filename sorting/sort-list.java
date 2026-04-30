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
        if (head == null || head.next == null){
            return head;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        Collections.sort(arr);
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        for (int i = 0; i < arr.size(); i++){
            ListNode node = new ListNode(arr.get(i));
            nodes.add(node);
        }
        for (int j = 0; j < nodes.size() - 1; j++){
            nodes.get(j).next = nodes.get(j + 1);
        }
        return nodes.get(0);
    }
}