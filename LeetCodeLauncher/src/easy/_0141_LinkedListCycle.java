package easy;

import Utilities.ListNode;

import java.util.ArrayList;

public class _0141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        var visitedNodes = new ArrayList<ListNode>();

        while(head != null){
            if(visitedNodes.contains(head)){
                return true;
            }
            visitedNodes.add(head);
            head = head.next;
        }

        return false;
    }

    public void run() {
        System.out.println("_0141_LinkedListCycle");
        System.out.println("Given: [3,2,0,-4] Expected: true Actual: "
                + hasCycle(prepareTestNodes()));
    }

    public ListNode prepareTestNodes(){
        var n4 = new ListNode(-4);

        var n0 = new ListNode(1, n4);
        var n2 = new ListNode(2, n0);
        var n3 = new ListNode(3, n2);

        //cycle to be detected
        n4.next = n2;

        return n3;
    }
}
