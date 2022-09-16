package easyLinkedList;

import Utilities.ListNode;
import java.util.Arrays;

public class _0083_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        var listNode = head;

        while(listNode.next != null){
            if(listNode.val == listNode.next.val){
                listNode.next = listNode.next.next;
                if(listNode.next == null){
                    break;
                }
            }
            else {
                listNode = listNode.next;
            }
        }

        return head;
    }

    public void run() {
        System.out.println("_0083_RemoveDuplicatesFromSortedList: ");
        System.out.println("Expected: [[]]  Actual: " +
                Arrays.toString(ListNode.NodesToArray(null)));
        System.out.println("Expected: [[1,2]]  Actual: " +
                Arrays.toString(ListNode.NodesToArray(deleteDuplicates(prepareTestNodes()))));
        System.out.println("Expected: [[1,2,3]]  Actual: " +
                Arrays.toString(ListNode.NodesToArray(deleteDuplicates(prepareTestNodes2()))));
    }

    public ListNode prepareTestNodes(){
        var n3 = new ListNode(2);
        var n2 = new ListNode(1, n3);
        var n1 = new ListNode(1, n2);

        return n1;
    }

    public ListNode prepareTestNodes2(){
        var n5 = new ListNode(3);
        var n4 = new ListNode(3, n5);
        var n3 = new ListNode(2, n4);
        var n2 = new ListNode(1, n3);
        var n1 = new ListNode(1, n2);

        return n1;
    }
}
