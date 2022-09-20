package easyLinkedList;

import Utilities.ListNode;
import java.util.Arrays;

public class _0203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode newHead = head;
        while(newHead != null && newHead.val == val){
            if(newHead.next == null) return null;
            newHead = newHead.next;
        }

        ListNode loopNode = newHead;
        while(loopNode.next != null){
            if(loopNode.next.val != val) loopNode = loopNode.next;
            else loopNode.next = loopNode.next.next;
        }

        return newHead;
    }

    public void run() {
        System.out.println("_0203_RemoveLinkedListElements: ");
        System.out.println("Expected: [2,3]  Actual: " +
            Arrays.toString(ListNode.NodesToArray(
                removeElements(prepareTestNodes(),1))));
    }

    public ListNode prepareTestNodes(){
        var n5 = new ListNode(1);
        var n4 = new ListNode(3, n5);
        var n3 = new ListNode(2, n4);
        var n2 = new ListNode(1, n3);
        var n1 = new ListNode(1, n2);

        return n1;
    }
}
