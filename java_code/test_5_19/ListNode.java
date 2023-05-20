package test_5_19;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static int getLinkedListLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

}