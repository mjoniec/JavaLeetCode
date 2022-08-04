package easy;

import Utilities.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static Utilities.ListNode.NodesToArray;

public class _0206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;

        while (head != null) {
            var tmp = head.next;
            head.next = reversedHead;
            reversedHead = head;
            head = tmp;
        }

        return reversedHead;
    }

    public void run() {
        System.out.println("_0206_ReverseLinkedList");
        System.out.println("Given: [1,2,3] Expected: [3,2,1] Actual: "
                + Arrays.toString(NodesToArray(reverseList(prepareTestNodes()))));
    }

    public ListNode prepareTestNodes(){
        var n3 = new ListNode(3);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);

        return n1;
    }
}