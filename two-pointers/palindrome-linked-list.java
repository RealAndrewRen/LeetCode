class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 and fast by 2, pushing first half values
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If odd length, skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        // Compare second half with stack
        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
