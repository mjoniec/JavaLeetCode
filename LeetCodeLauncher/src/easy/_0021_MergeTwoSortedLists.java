package easy;

import Utilities.ListNode;
import java.util.Arrays;
import static Utilities.ListNode.NodesToArray;

public class _0021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp = null;

        while(true){
            if(list1 == null && list2 == null){
                break;
            }

            if(list2 == null || list1.val < list2.val){
                tmp = list1;
                list1 = list1.next;
            }
            else if(list1 == null || list1.val >= list2.val){
                tmp = list2;
                list2 = list2.next;
            }
        }

        return null;
    }

    public void run() {
        System.out.println("_0021_MergeTwoSortedLists");
        System.out.println("Given: list1 = [1,2,4], list2 = [1,3,4] Expected: [1,1,2,3,4,4] Actual: "
                + Arrays.toString(NodesToArray(
                        mergeTwoLists(prepareTestNodes1(), prepareTestNodes2()))));
    }

    public ListNode prepareTestNodes1(){
        var n4 = new ListNode(4);
        var n2 = new ListNode(2, n4);
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
