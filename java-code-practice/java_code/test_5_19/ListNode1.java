package test_5_19;

public class ListNode1 {
        int val;
        ListNode next;
        ListNode1(int x) { val = x; }
    public static boolean searchForKeyword(ListNode head, int key) {
        ListNode current = head;
        while (current != null) {
            if (current.val == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

}



