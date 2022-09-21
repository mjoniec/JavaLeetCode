package easyLinkedList;

import Utilities.ListNode;
import java.util.Arrays;

import static Utilities.ListNode.NodesToArray;

public class _0876_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        var count = 0;
        ListNode loopNode = head;
        while(loopNode!=null){
            count++;
            loopNode = loopNode.next;
        }

        int index = 0;
        loopNode = head;
        while(index++ < count / 2){
            loopNode = loopNode.next;
        }

        return loopNode;
    }

    public void run() {
        System.out.println("_0876_MiddleOfTheLinkedList");
        System.out.println("Given: [1,2,3,4] Expected: 2,3  Actual: " +
                Arrays.toString(NodesToArray(middleNode(prepareTestNodes1()))));
        System.out.println("Given: [1,2,3] Expected: 2,3  Actual: " +
                Arrays.toString(NodesToArray(middleNode(prepareTestNodes2()))));
    }

    public ListNode prepareTestNodes1(){
        var n4 = new ListNode(1);
        var n3 = new ListNode(2, n4);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);
        return n1;
    }

    public ListNode prepareTestNodes2(){
        var n3 = new ListNode(3);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);
        return n1;
    }
}
