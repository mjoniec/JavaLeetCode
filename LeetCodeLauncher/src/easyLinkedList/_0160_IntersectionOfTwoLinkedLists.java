package easyLinkedList;

import Utilities.ListNode;
import java.util.Arrays;

public class _0160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA != nodeB){
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }

    public void run() {
        System.out.println("_0160_IntersectionOfTwoLinkedLists: ");
        Test1();
        Test2();
        Test3();
    }

    private void Test1() {
        var c3 = new ListNode(5);
        var c2 = new ListNode(4, c3);
        var c1 = new ListNode(8, c2);

        var a2 = new ListNode(1, c1);
        var a1 = new ListNode(4, a2);

        var b3 = new ListNode(1, c1);
        var b2 = new ListNode(6, b3);
        var b1 = new ListNode(5, b2);

        System.out.println("Expected: [[8,4,5]]  Actual: " +
                Arrays.toString(ListNode.NodesToArray(getIntersectionNode(a1, b1))));
    }

    private void Test2() {
        var c2 = new ListNode(4);
        var c1 = new ListNode(2, c2);

        var a3 = new ListNode(1, c1);
        var a2 = new ListNode(9, a3);
        var a1 = new ListNode(1, a2);

        var b1 = new ListNode(3, c1);

        System.out.println("Expected: [[2,4]]  Actual: " +
                Arrays.toString(ListNode.NodesToArray(getIntersectionNode(a1, b1))));
    }

    private void Test3() {
        var b2 = new ListNode(5);
        var b1 = new ListNode(1, b2);

        var a3 = new ListNode(4);
        var a2 = new ListNode(6, a3);
        var a1 = new ListNode(2, a2);

        System.out.println("Expected: [[]]  Actual: " +
                Arrays.toString(ListNode.NodesToArray(getIntersectionNode(a1, b1))));
    }
}
