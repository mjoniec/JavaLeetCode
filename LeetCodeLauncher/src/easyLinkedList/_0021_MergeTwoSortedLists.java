package easyLinkedList;

import Utilities.ListNode;
import java.util.Arrays;
import static Utilities.ListNode.NodesToArray;

public class _0021_MergeTwoSortedLists {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null || list2 == null) {
//            return list1 == null ? list2 : list1;
//        }
//
//        ListNode loop, head;
//        loop = head = list1.val < list2.val ? list1 : list2;
//
//        while(list1 != null && list2 != null){
//            if(loop == list1){
//                if(loop.next.val > list2.val){
//                    list1 = loop.next;
//                    loop.next = list2;
//                }
//            }
//            else{
//                if(loop.next.val > list1.val){
//                    list2 = loop.next;
//                    loop.next = list1;
//
//                }
//            }
//
//            loop = loop.next;
//
//            System.out.println("list1: " + Arrays.toString(NodesToArray(list1)));
//            System.out.println("list2: " + Arrays.toString(NodesToArray(list2)));
//            System.out.println("head: " + Arrays.toString(NodesToArray(head)));
//            System.out.println("loop: " + loop.val);
//        }
//
//        return head;
//    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode loop, head;
        loop = head = new ListNode(0);

        while(list1 != null && list2 != null){
            ListNode tmp;
            if(list1.val < list2.val){
                tmp = new ListNode(list1.val);
                list1 = list1.next;
            }
            else{
                tmp = new ListNode(list2.val);
                list2 = list2.next;
            }

            loop.next = tmp;
            loop = tmp;

//            System.out.println("list1: " + Arrays.toString(NodesToArray(list1)));
//            System.out.println("list2: " + Arrays.toString(NodesToArray(list2)));
//            System.out.println("head: " + Arrays.toString(NodesToArray(head)));
//            System.out.println("loop value: " + loop.val);
        }

        loop.next = list1 == null ? list2 : list1;

        return head.next;
    }

    public void run() {
        System.out.println("_0021_MergeTwoSortedLists");
        System.out.println("Given: list1 = [1,2,4], list2 = [1,3,4] Expected: [1,1,2,3,4,4] Actual: "
                + Arrays.toString(NodesToArray(
                        mergeTwoLists(prepareTestNodes1(), prepareTestNodes2()))));
    }

    public ListNode prepareTestNodes1(){
        var n4 = new ListNode(4);
        var n2 = new ListNode(3, n4);
        var n1 = new ListNode(1, n2);

        return n1;
    }

    public ListNode prepareTestNodes2(){
        var n4 = new ListNode(4);
        var n3 = new ListNode(3, n4);
        var n1 = new ListNode(1, n3);

        return n1;
    }
}
