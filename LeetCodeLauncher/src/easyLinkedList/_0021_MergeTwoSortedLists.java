package easyLinkedList;

import Utilities.ListNode;
import java.util.Arrays;
import static Utilities.ListNode.NodesToArray;

public class _0021_MergeTwoSortedLists {
    private ListNode list1;
    private ListNode list2;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        this.list1 = list1;
        this.list2 = list2;
        ListNode newHead = popSmallerHeadNodeWithListMaintenance();
        var loopNode = newHead;

        while(this.list1 != null && this.list2 != null){
            loopNode.next = popSmallerHeadNodeWithListMaintenance();
            loopNode = loopNode.next;
        }

        if(this.list1 != null) loopNode.next = this.list1;
        if(this.list2 != null) loopNode.next = this.list2;

        return newHead;
    }

    private ListNode popSmallerHeadNodeWithListMaintenance(){
        ListNode listNode;

        if(list1.val < list2.val){
            listNode = list1;
            list1 = list1.next;
        }
        else{
            listNode = list2;
            list2 = list2.next;
        }

        return listNode;
    }
    public void run() {
        System.out.println("_0021_MergeTwoSortedLists");
        System.out.println("Given: list1 = [2,3,6], list2 = [1,3,4] Expected: [1,2,3,3,4,6] Actual: "
            + Arrays.toString(NodesToArray(mergeTwoLists(prepareTestNodes1(), prepareTestNodes2()))));
    }

    public ListNode prepareTestNodes1(){
        var n4 = new ListNode(4);
        var n2 = new ListNode(3, n4);
        var n1 = new ListNode(1, n2);

        return n1;
    }

    public ListNode prepareTestNodes2(){
        var n4 = new ListNode(6);
        var n3 = new ListNode(3, n4);
        var n1 = new ListNode(2, n3);

        return n1;
    }
}
